package com.paging.model

import androidx.lifecycle.LiveData
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/13 0013
 *  @pkn    : com.paging.model
 *  @desc   :
 */

/**
 * RecyclerView中item展示的数据,既后台服务器获取的数据,将他保存在数据库中
 */
@Entity(tableName = "repos")
data class Repo(
    @PrimaryKey @field:SerializedName("id") val id: Long,
    @field:SerializedName("name") val name: String,
    @field:SerializedName("fullName") val fullName: String,
    @field:SerializedName("description") val description: String?,
    @field:SerializedName("url") val url: String,
    @field:SerializedName("stars") val stars: Int,
    @field:SerializedName("forks") val forks: Int,
    @field:SerializedName("language") val language: String?
)

/**
 * 搜索数据:搜索结果-网络错误信息
 */
data class RepoSearchResult(val data: LiveData<List<Repo>>, val networkErrors: LiveData<String>)