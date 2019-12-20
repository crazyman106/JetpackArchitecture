package com.test.paging_network_lib.reddit.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.Transformations.*
import androidx.lifecycle.ViewModel
import com.test.paging_network_lib.reddit.repository.Listing
import com.test.paging_network_lib.reddit.repository.RedditPostRepository
import com.test.paging_network_lib.reddit.vo.RedditPost

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/19 0019
 *  @pkn    : com.test.paging_network_lib.reddit.ui
 *  @desc   :
 *
 *     private val repoResult2 = Transformations.switchMap(subredditName){
 *        repository.postsOfSubreddit(it,30).networkState
 *     }
 */
class SubRedditViewModel(private val repository: RedditPostRepository) : ViewModel() {
    private val subredditName = MutableLiveData<String>()
    private val repoResult = map(subredditName) { repository.postsOfSubreddit(it, 30) }

    val posts = switchMap(repoResult) { it.pagedList }

    val networkState = switchMap(repoResult) { it.networkState }

    val refreshState = switchMap(repoResult) { it.refreshState }

    fun showSubreddit(subreddit: String): Boolean =
        if (subredditName.value == subreddit) {
            false
        } else {
            subredditName.value = subreddit
            true
        }

    fun refresh() =
        repoResult.value?.refresh?.invoke()


    fun retry() =
        repoResult?.value?.retry?.invoke()


    fun currentSubreddit(): String? = subredditName.value
}