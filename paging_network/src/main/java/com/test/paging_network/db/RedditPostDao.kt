package com.test.paging_network.db

import androidx.paging.DataSource
import androidx.room.*
import com.test.paging_network_lib.reddit.vo.RedditPost

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/19 0019
 *  @pkn    : com.test.paging_network.db
 *  @desc   :
 */
@Dao
interface RedditPostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<RedditPost>)

    @Query("SELECT * FROM posts where subreddit=:subreddit order by indexInResponse asc")
    fun postsBySubreddit(subreddit: String): DataSource.Factory<Int, RedditPost>

    @Query("delete FROM posts WHERE subreddit = :subreddit")
    fun deleteBySubreddit(subreddit: String)

    @Query("select MAX(indexInResponse) + 1 from posts where subreddit = :subreddit")
    fun getNextIndexInSubreddit(subreddit: String): Int
}