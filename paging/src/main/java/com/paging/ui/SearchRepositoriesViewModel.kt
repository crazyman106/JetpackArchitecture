package com.paging.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.paging.data.GithubDataRepository
import com.paging.model.Repo
import com.paging.model.RepoSearchResult

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/16 0016
 *  @pkn    : com.paging.ui
 *  @desc   :
 */
class SearchRepositoriesViewModel(private val repository: GithubDataRepository) : ViewModel() {
    companion object {
        private const val VISIBLE_THRESHOLD = 5
    }

    private val queryLiveData = MutableLiveData<String>()
    private val repoResult: LiveData<RepoSearchResult> = Transformations.map(queryLiveData) {
        repository.search(it)
    }
    val repos: LiveData<List<Repo>> = Transformations.switchMap(repoResult) {
        it.data
    }
    val networkErrors: LiveData<String> = Transformations.switchMap(repoResult) {
        it.networkErrors
    }

    fun searchRepo(queryString: String) {
        queryLiveData.postValue(queryString)
    }

    fun lastQueryValue(): String? = queryLiveData.value

    fun listScrolled(visibleItemCount: Int, lastVisibleItemPosition: Int, totalItemCount: Int) {
        if (visibleItemCount + lastVisibleItemPosition + VISIBLE_THRESHOLD >= totalItemCount) {
            val immutableQuery = lastQueryValue()
            if (immutableQuery != null) {
                repository.requestMore(immutableQuery)
            }
        }
    }
}