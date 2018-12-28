@file:JvmName("NovelListAdapter")

package c.offwhite.sampledi.ui.main

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import c.offwhite.sampledi.R
import c.offwhite.sampledi.databinding.MainItemBinding
import c.offwhite.novel.domain.NovelIntroduction

/**
 * 小説リスト表示アダプター
 */
class NovelListAdapter : RecyclerView.Adapter<NovelListAdapter.ViewHolder>() {

    // 表示アイテム
    private var novelList: List<NovelIntroduction> = emptyList()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder && novelList.size > position) {
            holder.bind(novelList[position])
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

        fun bind(item: NovelIntroduction) {
            binding.item = item
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
}