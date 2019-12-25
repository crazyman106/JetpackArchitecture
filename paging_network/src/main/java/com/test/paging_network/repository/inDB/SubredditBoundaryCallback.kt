package com.test.paging_network.repository.inDB

import androidx.annotation.MainThread
import androidx.paging.PagedList
import androidx.paging.PagingRequestHelper
import com.test.paging_network.api.RedditApi
import com.test.paging_network.util.createStatusLiveData
import com.test.paging_network_lib.reddit.vo.RedditPost
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/24 0024
 *  @pkn    : com.test.paging_network.repository.inDB
 *  @desc   :
 *
 *  当用户到达列表的边缘，数据库无法提供更多数据时，此边界回调将得到通知。
 *  对于相同的方向，可以多次调用边界回调，因此它使用PagingRequestHelper类执行自己的速率限制。
 */
class SubredditBoundaryCallback(
    private val subredditName: String,
    private val webservice: RedditApi,
    private val handleResponse: (String, RedditApi.ListingResponse?) -> Unit,
    private val ioExecutor: Executor,
    private val networkPageSize: Int
) : PagedList.BoundaryCallback<RedditPost>() {
    val helper = PagingRequestHelper(ioExecutor)
    val networkState = helper.createStatusLiveData()
    @MainThread
    override fun onItemAtEndLoaded(itemAtEnd: RedditPost) {
        helper.runIfNotRunning(PagingRequestHelper.RequestType.AFTER) {
            webservice.getTopAfter(
                subreddit = subredditName,
                limit = networkPageSize,
                after = itemAtEnd.name
            ).enqueue(createWebserviceCallback(it))
        }
    }

    /**
     * Database returned 0 items. We should query the backend for more items.
     */
    @MainThread
    override fun onZeroItemsLoaded() {
        helper.runIfNotRunning(PagingRequestHelper.RequestType.INITIAL) {
            webservice.getTop(
                subreddit = subredditName,
                limit = networkPageSize
            ).enqueue(createWebserviceCallback(it))
        }
    }

    override fun onItemAtFrontLoaded(itemAtFront: RedditPost) {
        super.onItemAtFrontLoaded(itemAtFront)
    }

    private fun createWebserviceCallback(it: PagingRequestHelper.Request.Callback)
            : Callback<RedditApi.ListingResponse> {
        return object : Callback<RedditApi.ListingResponse> {
            override fun onFailure(
                call: Call<RedditApi.ListingResponse>,
                t: Throwable
            ) {
                it.recordFailure(t)
            }

            override fun onResponse(
                call: Call<RedditApi.ListingResponse>,
                response: Response<RedditApi.ListingResponse>
            ) {
                insertItemsIntoDb(response, it)
            }
        }
    }


    /**
     * every time it gets new items, boundary callback simply inserts them into the database and
     * paging library takes care of refreshing the list if necessary.
     */
    private fun insertItemsIntoDb(
        response: Response<RedditApi.ListingResponse>,
        it: PagingRequestHelper.Request.Callback
    ) {
        ioExecutor.execute {
            handleResponse(subredditName, response.body())
            it.recordSuccess()
        }
    }
}