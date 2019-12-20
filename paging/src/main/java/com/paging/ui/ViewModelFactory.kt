package com.paging.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.paging.data.GithubDataRepository

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/16 0016
 *  @pkn    : com.paging.ui
 *  @desc   :
 */
class ViewModelFactory(private val repository: GithubDataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchRepositoriesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SearchRepositoriesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}