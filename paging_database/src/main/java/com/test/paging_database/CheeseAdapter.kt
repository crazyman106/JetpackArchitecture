package com.test.paging_database

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_database
 *  @desc   :
 */
class CheeseAdapter : PagedListAdapter<Cheese, CheeseViewHolder>(diffCallback) {

    companion object {
        private val diffCallback = object : ItemCallback<Cheese>() {
            override fun areItemsTheSame(oldItem: Cheese, newItem: Cheese): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Cheese, newItem: Cheese): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheeseViewHolder =
        CheeseViewHolder(parent)

    override fun onBindViewHolder(holder: CheeseViewHolder, position: Int) {
        holder.bindToView(getItem(position))
    }
}