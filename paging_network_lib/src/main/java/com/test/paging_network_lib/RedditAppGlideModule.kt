package com.test.paging_network_lib

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.test.paging_network_lib.reddit.repository.NetworkState

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_network_lib.reddit
 *  @desc   :
 */
@GlideModule
class RedditAppGlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        // TODO 添加参数配置
    }
}