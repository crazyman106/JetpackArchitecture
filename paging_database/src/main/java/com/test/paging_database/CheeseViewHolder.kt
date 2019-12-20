package com.test.paging_database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cheese_item.view.*

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_database
 *  @desc   :
 */
class CheeseViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(
        R.layout.cheese_item,
        parent,
        false
    )
) {

    var cheese: Cheese? = null

    fun bindToView(cheese: Cheese?) {
        this.cheese = cheese
        itemView.name.text = cheese?.name
    }
}