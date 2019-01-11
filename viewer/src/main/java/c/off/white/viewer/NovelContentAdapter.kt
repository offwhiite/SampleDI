package c.off.white.viewer

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import c.off.white.viewer.databinding.ContentItemBinding
import c.offwhite.novel.domain.Contents
import c.offwhite.novel.domain.PageInfo

/**
 * 目次リスト作成
 */
class NovelContentAdapter : RecyclerView.Adapter<NovelContentAdapter.ContentViewHolder>() {

    var contents: Contents? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ContentViewHolder {
        return ContentViewHolder(parent)
    }

    /**
     * ページの総数を返す。TODO : タイトルをまだカウントしていない。
     */
    override fun getItemCount(): Int {

        var itemCount = 0

        contents?.chapters?.forEach { itemCount += it.pageInfo.size }

        return itemCount
    }

    override fun onBindViewHolder(contentViewHolder: ContentViewHolder, p1: Int) {

        var chapter = 0
        var sumPageCount = 0
        contents?.chapters?.forEach {
            if (sumPageCount < p1) {
                chapter++
                sumPageCount += p1
            }
        }

        contentViewHolder.bind(contents?.chapters!![chapter].pageInfo[p1-sumPageCount])
    }


    /**
     * 目次ビューのViewHolder
     */
    class ContentViewHolder(
        private val parent: ViewGroup,
        private val binding: ContentItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.content_item,
            parent,
            false
        )
    ) : RecyclerView.ViewHolder(parent) {
        fun bind(pageInfo: PageInfo) {
            binding.item = pageInfo
        }
    }

    interface OnItemClickListener {
        fun onContentClick(pageNum: Int)
    }
}