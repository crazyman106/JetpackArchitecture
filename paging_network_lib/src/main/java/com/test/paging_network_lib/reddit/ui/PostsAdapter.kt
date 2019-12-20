package com.test.paging_network_lib.reddit.ui

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.paging_network_lib.GlideRequests
import com.test.paging_network_lib.R
import com.test.paging_network_lib.reddit.repository.NetworkState
import com.test.paging_network_lib.reddit.vo.RedditPost

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/19 0019
 *  @pkn    : com.test.paging_network_lib.reddit.ui
 *  @desc   :
 */
class PostsAdapter(
    private val glide: GlideRequests,
    private val retryCallback: () -> Unit
) : PagedListAdapter<RedditPost, RecyclerView.ViewHolder>(POST_COMPARATOR) {

    private var networkState: NetworkState? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.reddit_post_item -> (holder as RedditPostViewHolder).bind(getItem(position))
            R.layout.network_state_item -> (holder as NetworkStateItemViewHolder).bind(networkState)
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isNotEmpty()) {
            val item = getItem(position)
            (holder as RedditPostViewHolder).updateScore(item)
        } else {
            onBindViewHolder(holder, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.reddit_post_item -> RedditPostViewHolder.create(parent, glide)
            R.layout.network_state_item -> NetworkStateItemViewHolder.create(parent, retryCallback)
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }

    override fun getItemViewType(position: Int): Int =
        if (hasExtraRow() && position == itemCount - 1) {
            R.layout.network_state_item
        } else {
            R.layout.reddit_post_item
        }

    override fun getItemCount(): Int = super.getItemCount() + if (hasExtraRow()) 1 else 0

    fun setNetworkState(newNetworkState: NetworkState?) {
        val previousState = this.networkState
        val hadExtraRow = this.hasExtraRow()
        this.networkState = newNetworkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemInserted(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }
    }

    private fun hasExtraRow(): Boolean = networkState != null && networkState != NetworkState.LOADED

    companion object {
        private val PAYLOAD_SCORE = Any()

        val POST_COMPARATOR = object : DiffUtil.ItemCallback<RedditPost>() {
            override fun areItemsTheSame(oldItem: RedditPost, newItem: RedditPost): Boolean =
                oldItem.name == newItem.name


            override fun areContentsTheSame(oldItem: RedditPost, newItem: RedditPost): Boolean =
                oldItem == newItem


            override fun getChangePayload(oldItem: RedditPost, newItem: RedditPost): Any? {
                return if (sameExceptScore(oldItem, newItem)) {
                    PAYLOAD_SCORE
                } else {
                    null
                }
            }
        }

        private fun sameExceptScore(oldItem: RedditPost, newItem: RedditPost): Boolean {
            return oldItem.copy(score = newItem.score) == newItem
        }
    }
}