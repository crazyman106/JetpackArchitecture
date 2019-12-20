package com.test.paging_network.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingRequestHelper
import com.test.paging_network_lib.reddit.repository.NetworkState

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/19 0019
 *  @pkn    : com.test.paging_network.util
 *  @desc   :
 */
private fun getErrorMessage(report: PagingRequestHelper.StatusReport): String {
    return PagingRequestHelper.RequestType.values().mapNotNull {
        report.getErrorFor(it)?.message
    }.first()
}

fun PagingRequestHelper.createStatusLiveData(): LiveData<NetworkState> {
    val liveData = MutableLiveData<NetworkState>()
    addListener {
        when {
            it.hasRunning() -> liveData.postValue(NetworkState.LOADING)
            it.hasError() -> liveData.postValue(NetworkState.error(getErrorMessage(it)))
            else -> liveData.postValue(NetworkState.LOADED)
        }
    }
    return liveData
}