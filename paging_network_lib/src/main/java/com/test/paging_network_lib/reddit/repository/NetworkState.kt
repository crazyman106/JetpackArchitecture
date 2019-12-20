package com.test.paging_network_lib.reddit.repository

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_network_lib.reddit.repository
 *  @desc   :
 */

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

data class NetworkState private constructor(
    val status: Status,
    val msg: String? = null
) {
    companion object {
        val LOADED = NetworkState(status = Status.SUCCESS)
        val LOADING = NetworkState(status = Status.RUNNING)
        fun error(msg: String?) = NetworkState(Status.FAILED, msg)
    }
}