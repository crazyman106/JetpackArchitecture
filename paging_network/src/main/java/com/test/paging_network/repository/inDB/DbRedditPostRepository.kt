package com.test.paging_network.repository.inDB

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.toLiveData
import com.test.paging_network.api.RedditApi
import com.test.paging_network.db.RedditDb
import com.test.paging_network_lib.reddit.repository.Listing
import com.test.paging_network_lib.reddit.repository.NetworkState
import com.test.paging_network_lib.reddit.repository.RedditPostRepository
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
 */
class DbRedditPostRepository(
    val db: RedditDb,
    private val redditApi: RedditApi,
    private val ioExecutor: Executor,
    private val networkPageSize: Int = DEFAULT_NETWORK_PAGE_SIZE
) : RedditPostRepository {

    companion object {
        private const val DEFAULT_NETWORK_PAGE_SIZE = 10
    }

    /**
     * Returns a Listing for the given subreddit.
     */
    override fun postsOfSubreddit(subReddit: String, pageSize: Int): Listing<RedditPost> {
        val boundaryCallback =
            SubredditBoundaryCallback(
                webservice = redditApi,
                subredditName = subReddit,
                handleResponse = this::insertResultIntoDb,
                ioExecutor = ioExecutor,
                networkPageSize = networkPageSize
            )
        val refreshTrigger = MutableLiveData<Unit>()
        val refreshState = Transformations.switchMap(refreshTrigger) {
            refresh(subReddit)
        }
        // We use toLiveData Kotlin extension function here, you could also use LivePagedListBuilder
        val livePagedList = db.posts().postsBySubreddit(subReddit).toLiveData(
            pageSize = pageSize,
            boundaryCallback = boundaryCallback
        )
        return Listing(
            pagedList = livePagedList,
            networkState = boundaryCallback.networkState,
            retry = {
                boundaryCallback.helper.retryAllFailed()
            },
            refresh = {
                refreshTrigger.value = null
            },
            refreshState = refreshState
        )
    }

    /**
     * When refresh is called, we simply run a fresh network request and when it arrives, clear
     * the database table and insert all new items in a transaction.
     * <p>
     * Since the PagedList already uses a database bound data source, it will automatically be
     * updated after the database transaction is finished.
     */
    @MainThread
    private fun refresh(subredditName: String): LiveData<NetworkState> {
        val networkState = MutableLiveData<NetworkState>()
        networkState.value = NetworkState.LOADING
        redditApi.getTop(subredditName, networkPageSize).enqueue(
            object : Callback<RedditApi.ListingResponse> {
                override fun onFailure(call: Call<RedditApi.ListingResponse>, t: Throwable) {
                    // retrofit calls this on main thread so safe to call set value
                    networkState.value = NetworkState.error(t.message)
                }

                override fun onResponse(
                    call: Call<RedditApi.ListingResponse>,
                    response: Response<RedditApi.ListingResponse>
                ) {
                    ioExecutor.execute {
                        db.runInTransaction {
                            db.posts().deleteBySubreddit(subredditName)
                            insertResultIntoDb(subredditName, response.body())
                        }
                        // since we are in bg thread now, post the result.
                        networkState.postValue(NetworkState.LOADED)
                    }
                }
            }
        )
        return networkState
    }

    /**
     * Inserts the response into the database while also assigning position indices to items.
     */
    private fun insertResultIntoDb(subredditName: String, body: RedditApi.ListingResponse?) {
        body!!.data.children.let { posts ->
            db.runInTransaction {
                //RoomDatabase执行事务
                val start = db.posts().getNextIndexInSubreddit(subredditName)
                val items = posts.mapIndexed { index, child ->
                    child.data.indexInResponse = start + index
                    child.data
                }
                db.posts().insert(items)
            }
        }
    }

}