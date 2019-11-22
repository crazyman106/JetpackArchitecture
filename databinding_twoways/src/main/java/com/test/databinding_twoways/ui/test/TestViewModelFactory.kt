package com.example.android.databinding.twowaysample.ui.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/11/22 0022
 *  @pkn    : com.example.android.databinding.twowaysample.ui.test
 *  @desc   :
 */
object TestViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TestViewModel::class.java)) {
            return TestViewModel() as T
        }
        throw IllegalArgumentException("Unknown class viewmodel")
    }
}
