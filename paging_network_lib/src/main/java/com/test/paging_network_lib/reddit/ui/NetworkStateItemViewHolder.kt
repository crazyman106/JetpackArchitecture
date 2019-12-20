package com.test.paging_network_lib.reddit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.paging_network_lib.R
import com.test.paging_network_lib.reddit.repository.NetworkState
import com.test.paging_network_lib.reddit.repository.Status
import kotlinx.android.synthetic.main.network_state_item.view.*

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_network_lib.reddit.ui
 *  @desc   :
 */
class NetworkStateItemViewHolder(itemView: View, private val retryCallback: () -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    init {
        itemView.retry_button.setOnClickListener {
            retryCallback
        }
    }

    fun bind(networkState: NetworkState?) {
        itemView.progress_bar.visibility = toVisibility(networkState?.status == Status.RUNNING)
        itemView.retry_button.visibility = toVisibility(networkState?.status == Status.FAILED)
        itemView.error_msg.visibility = toVisibility(networkState?.msg != null)
        itemView.error_msg.text = networkState?.msg
    }

    companion object {
        fun create(parent: ViewGroup, retryCallback: () -> Unit) = NetworkStateItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.network_state_item, parent, false
            )
            , retryCallback
        )

        private fun toVisibility(constraint: Boolean): Int =
            if (constraint) View.VISIBLE else View.GONE

    }
}
