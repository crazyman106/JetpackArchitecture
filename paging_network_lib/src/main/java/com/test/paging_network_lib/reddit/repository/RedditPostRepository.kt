package com.test.paging_network_lib.reddit.repository

import com.test.paging_network_lib.reddit.vo.RedditPost

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_network_lib.reddit.repository
 *  @desc   :
 *
 *  由不同的存储库实现共享的公共接口
 */
interface RedditPostRepository {
    fun postsOfSubreddit(subReddit: String, pageSize: Int): Listing<RedditPost>

    enum class Type {
        IN_MEMORY_BY_ITEM,
        IN_MEMORY_BY_PAGE,
        DB
    }
}