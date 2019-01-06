@file:JvmName("NovelListAdapter")

package c.offwhite.sampledi.ui.main

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import c.offwhite.novel.domain.NovelIntroduction
import c.offwhite.sampledi.R
import c.offwhite.sampledi.databinding.MainItemBinding

/**
 * 小説リスト表示アダプター
 */
class NovelListAdapter(private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<NovelListAdapter.ViewHolder>() {

    // 表示アイテム
    private var novelList: List<NovelIntroduction> = emptyList()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder && novelList.size > position) {
            holder.bind(holder.itemView, novelList[position], onItemClickListener)
        }
    }

    override fun getItemCount(): Int {
        return novelList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovelListAdapter.ViewHolder {
        return ItemViewHolder(parent)
    }

    /**
     * データをセットしてアップデートする
     */
    fun update(novelList: List<NovelIntroduction>) {
        this.novelList = novelList
        notifyDataSetChanged()
    }

    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
    class ItemViewHolder(
            private val parent: ViewGroup,
            private val binding: MainItemBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.main_item,
                    parent,
                    false
            )
    ) : ViewHolder(binding.root) {

        fun bind(view: View, item: NovelIntroduction, onItemClickListener: OnItemClickListener) {
            binding.item = item
            view.setOnClickListener { onItemClickListener.onItemClick(view.context, item.ncode) }
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun RecyclerView.bindItems(items: List<NovelIntroduction>?) {

            // まだ情報が取得できていない場合はitemsがnullになる可能性があるため、nullチェック必須。
            if (items == null) {
                return
            }

            //  RecyclerView.Adapterを継承しているので、RecyclerViewに設定されているadapterを取得できる
            val adapter = adapter as NovelListAdapter
            adapter.update(items)
        }
    }


    interface OnItemClickListener {
        fun onItemClick(context: Context, ncode: String)
    }
}