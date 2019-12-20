package com.test.paging_network_lib.reddit.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_network_lib.reddit.repository
 *  @desc   : 数据类，这是UI显示列表和与系统其余部分交互所必需的
 */
data class Listing<T>(
    val pagedList: LiveData<PagedList<T>>,// 要观察的分页列表的LiveData
    val networkState: LiveData<NetworkState>, // 表示要显示给用户的网络请求状态
    val refreshState: LiveData<NetworkState>, //表示要向用户显示的刷新状态。仅仅才刷新数据时使用
    val refresh: () -> Unit,
    val retry: () -> Unit //重试任何失败的请求。
) {
}