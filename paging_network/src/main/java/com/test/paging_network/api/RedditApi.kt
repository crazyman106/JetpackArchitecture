package com.test.paging_network.api

import com.test.paging_network_lib.reddit.vo.RedditPost
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/19 0019
 *  @pkn    : com.test.paging_network.api
 *  @desc   :
 */
interface RedditApi {

    @GET("/r/{subreddit}/hot.json")
    fun getTop(@Path("subreddit") subreddit: String, @Query("limit") limit: Int): Call<ListingResponse>

    @GET("/r/{subreddit}/hot.json")
    fun getTopBefore(@Path("subreddit") subreddit: String, @Query("before") before: String, @Query("limit") limit: Int): Call<ListingResponse>

    @GET("/r/{subreddit}/hot.json")
    fun getTopAfter(@Path("subreddit") subreddit: String, @Query("after") after: String, @Query("limit") limit: Int): Call<ListingResponse>

    class ListingResponse(val data: ListingData)
    class ListingData(
        val children: List<RedditChildrenResponse>,
        val after: String?,
        val before: String?
    )

    data class RedditChildrenResponse(val data: RedditPost)

    companion object {
        private const val BASE_URL = "https://www.reddit.com/"

        fun create(): RedditApi {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
            return Retrofit.Builder()
                .baseUrl(HttpUrl.parse(BASE_URL))
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(RedditApi::class.java)
        }
    }
}