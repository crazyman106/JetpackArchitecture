package com.livedata.other

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.math.BigDecimal

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/9 0009
 *  @pkn    : com.livedata
 *  @desc   : LiveData可以在多个activity或fragment之间实现数据共享
 */

class NameViewModel : ViewModel() {
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}

class StockLiveData : LiveData<BigDecimal>() {
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val listener = { price: BigDecimal ->
        value = price
    }

    override fun onActive() {
        // TODO 接受数据
    }

    override fun onInactive() {
        // TODO 不接受数据
    }
}