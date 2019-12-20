package com.test.paging_database

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_database
 *  @desc   :
 */
class CheeseViewModel(context: Application) : AndroidViewModel(context) {
    private val dao = CheeseDatabase.getInstance(context).cheeseDao()

    val allCheeses = LivePagedListBuilder(
        dao.allCheesesByName(),
        PagedList.Config.Builder().setPageSize(20).setEnablePlaceholders(true).setMaxSize(200).build()
    ).build()

    fun insert(text: CharSequence) = ioThread {
        dao.insert(Cheese(id = 0, name = text.toString()))
    }

    fun remove(cheese: Cheese) = ioThread {
        dao.delete(cheese)
    }

}