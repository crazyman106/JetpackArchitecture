package com.test.paging_network_lib.reddit.vo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_network_lib.reddit.vo
 *  @desc   :
 */
@Entity(tableName = "posts", indices = arrayOf(Index(value = arrayOf("subreddit"), unique = false)))
data class RedditPost(
    @PrimaryKey
    @SerializedName("name")
    val name: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("score")
    val score: Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("subreddit") // this seems mutable but fine for a demo
    @ColumnInfo(collate = ColumnInfo.NOCASE)
    val subreddit: String,
    @SerializedName("num_comments")
    val num_comments: Int,
    @SerializedName("created_utc")
    val created: Long,
    val thumbnail: String?,
    val url: String?
) {
    // to be consistent w/ changing backend order, we need to keep a data like this
    var indexInResponse: Int = -1
}