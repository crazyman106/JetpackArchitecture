package com.paging.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.paging.api.GithubService
import com.paging.api.searchRepos
import com.paging.db.GithubLocalRepository
import com.paging.model.RepoSearchResult

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/16 0016
 *  @pkn    : com.paging.data
 *  @desc   : 数据引擎:通过网络引擎获取数据,通过本地数据引擎保存数据更新数据
 *
 *  网络接口获取数据
 *      成功:使用本地数据库引擎将数据异步保存到数据库,修改网络状态.最后将数据映射到viewmodel中,刷新ui页面
 *
 *      失败:修改网络状态,数据不变,通知ui页面网络错误
 */
class GithubDataRepository(
    private val service: GithubService,
    private val repository: GithubLocalRepository
) {
    // keep the last requested page. When the request is successful, increment the page number.
    private var lastRequestedPage = 1

    // LiveData of network errors.
    private val networkErrors = MutableLiveData<String>()

    // avoid triggering multiple requests in the same time
    private var isRequestInProgress = false


    fun requestMore(query: String) {
        requestAndSaveData(query)
    }

    fun search(query: String): RepoSearchResult {
        Log.d("GithubRepository", "New query: $query")
        lastRequestedPage = 1
        requestAndSaveData(query)
        val data = repository.reposByName(query)
        return RepoSearchResult(data, networkErrors)
    }

    private fun requestAndSaveData(query: String) {
        if (isRequestInProgress) return
        isRequestInProgress = true
        searchRepos(service, query, lastRequestedPage, NETWORK_PAGE_SIZE, {
            repository.insert(it) {
                lastRequestedPage++
                isRequestInProgress = false
            }
        }, {
            networkErrors.postValue(it)
            isRequestInProgress = false
        })
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50
    }
}