package com.test.databinding_twoways.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.databinding_twoways.util.DefaultTimer

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/11/18 0018
 *  @pkn    : com.test.databinding_twoways.data
 *  @desc   :
 */
object IntervalTimerViewModelFactory : ViewModelProvider.Factory {
    /**
     * isAssignableFrom()方法与instanceof关键字的区别总结为以下两个点：
     *
     * 1. isAssignableFrom()方法是从类继承的角度去判断，instanceof关键字是从实例继承的角度去判断。父类.class.isAssignableFrom(子类.class)
     * 2. isAssignableFrom()方法是判断是否为某个类的父类，instanceof关键字是判断是否某个类的子类。子类实例 instanceof 父类类型
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IntervalTimerViewModel::class.java)) {
            return IntervalTimerViewModel(DefaultTimer) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}