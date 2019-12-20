package com.test.paging_network_lib.reddit.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.paging_network_lib.GlideRequests
import com.test.paging_network_lib.R
import com.test.paging_network_lib.reddit.vo.RedditPost
import kotlinx.android.synthetic.main.reddit_post_item.view.*

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/18 0018
 *  @pkn    : com.test.paging_network_lib.reddit.ui
 *  @desc   :
 */
class RedditPostViewHolder(itemView: View, private val glide: GlideRequests) :
    RecyclerView.ViewHolder(itemView) {
    private var post: RedditPost? = null


    init {
        itemView.setOnClickListener {
            post?.url?.let {
                itemView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it)))
            }
        }
    }

    fun bind(post: RedditPost?) {
        this.post = post
        itemView.title.text = post?.title ?: "loading"
        itemView.subtitle.text = itemView.context.resources.getString(
            R.string.post_subtitle,
            post?.author ?: "unknown"
        )
        itemView.score.text = "${post?.score ?: 0}"
        if (post?.thumbnail?.startsWith("http") == true) {
            itemView.thumbnail.visibility = View.VISIBLE
            glide.load(post.thumbnail).centerCrop()
                .placeholder(R.drawable.ic_insert_photo_black_48dp).into(itemView.thumbnail)
        } else {
            itemView.thumbnail.visibility = View.GONE
            glide.clear(itemView.thumbnail)
        }
    }

    companion object {
        fun create(parent: ViewGroup, glide: GlideRequests) = RedditPostViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.reddit_post_item, parent, false), glide
        )
    }

    fun updateScore(item: RedditPost?) {
        post = item
        itemView.score.text = "${item?.score ?: 0}"
    }
}