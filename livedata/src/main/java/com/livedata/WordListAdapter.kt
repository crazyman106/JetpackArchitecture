package com.livedata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*

/**
 *  @author : fengzili on
 *  @email  : 291924028@qq.com
 *  @date   : 2019/12/11 0011
 *  @pkn    : com.livedata
 *  @desc   :
 *
 *  private 只在该类(以及它的成员)中可见+
 *  protected 和 private 一样但在子类中也可见
 *  internal 在本模块的所有可以访问到声明区域的均可以访问该类的所有 internal 成员
 *  public 任何地方可见
 */
class WordListAdapter internal constructor() :
    RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {
    private var words = emptyList<Word>() // Cached copy of words

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder =
        WordViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        )

    override fun getItemCount(): Int = words.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.itemView.textView.text = words[position].word
    }

    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }
}