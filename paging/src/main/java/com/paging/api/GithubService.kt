package com.paging.api

import android.util.Log
import com.paging.model.Repo
import com.paging.model.RepoSearchResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/16 0016
 *  @pkn    : com.paging.api
 *  @desc   : 网络数据操作
 */


private const val TAG = "GithubService"
private const val IN_QUALIFIER = "in:name,description"


/**
 * 使用接口获取网络数据,之后,通过onSuccess()和onError()对函数返回结果进行回调,通知调用者
 */
fun searchRepos(
    service: GithubService,
    query: String,
    page: Int,
    itemsPerPage: Int,
    onSuccess: (repos: List<Repo>) -> Unit,
    onError: (error: String) -> Unit
) {
    Log.d(TAG, "query: $query, page: $page, itemsPerPage: $itemsPerPage")
    val apiQuery = query + IN_QUALIFIER

    service.searchRepos(apiQuery, page, itemsPerPage)
        .enqueue(object : Callback<RepoSearchResponse> {
            override fun onFailure(call: Call<RepoSearchResponse>, t: Throwable) {
                Log.d(TAG, "fail to get data")
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(
                call: Call<RepoSearchResponse>,
                response: Response<RepoSearchResponse>
            ) {
                Log.d(TAG, "got a response $response")
                if (response.isSuccessful) {
                    val repos = response.body()?.items ?: emptyList()
                    onSuccess(repos)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }

        })
}

interface GithubService {

    @GET("search/repositories?sort=stars")
    fun searchRepos(
        @Query("q") query: String, @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): Call<RepoSearchResponse>

    // 生成Api网络接口对象
    companion object {
        private const val BASE_URL = "https://api.github.com/"

        fun create(): GithubService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(logger).build()
            return Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)
        }
    }
}