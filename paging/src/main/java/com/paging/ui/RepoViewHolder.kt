package com.paging.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paging.R
import com.paging.model.Repo
import kotlinx.android.synthetic.main.repo_view_item.view.*

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/16 0016
 *  @pkn    : com.paging.ui
 *  @desc   :
 */
class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var repo: Repo? = null

    init {
        itemView.setOnClickListener {
            repo?.url?.let { url ->
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                itemView.context.startActivity(intent)
            }
        }
    }

    fun bind(repo: Repo?) {
        if (repo == null) {
            val resources = itemView.resources
            itemView.repo_name.text = resources.getString(R.string.loading)
            itemView.repo_description.text = ""
            itemView.repo_language.visibility = View.GONE
            itemView.repo_stars.text = resources.getString(R.string.unknown)
            itemView.repo_forks.text = resources.getString(R.string.unknown)
        } else {
            showRepoData(repo)
        }
    }

    private fun showRepoData(repo: Repo) {
        this.repo = repo


        itemView.repo_name.text = repo.fullName

        // if the description is missing, hide the TextView
        var descriptionVisibility = View.GONE
        if (repo.description != null) {
            itemView.repo_description.text = repo.description
            descriptionVisibility = View.VISIBLE
        }
        itemView.repo_description.visibility = descriptionVisibility

        itemView.repo_stars.text = repo.stars.toString()
        itemView.repo_forks.text = repo.forks.toString()

        // if the language is missing, hide the label and the value
        var languageVisibility = View.GONE
        if (!repo.language.isNullOrEmpty()) {
            val resources = this.itemView.context.resources
            itemView.repo_language.text = resources.getString(R.string.language, repo.language)
            languageVisibility = View.VISIBLE
        }
        itemView.repo_language.visibility = languageVisibility
    }


    companion object {
        fun create(parent: ViewGroup): RepoViewHolder = RepoViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.repo_view_item, parent, false)
        )

    }
}