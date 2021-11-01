package com.app.feeds.ui.feed.core.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.feeds.data.domain.entity.FeedItem
import com.app.feeds.databinding.ItemTrimIdeasBinding
import com.app.feeds.ui.feed.core.adapter.FeedAdapter
import com.app.feeds.ui.feed.core.adapter.ViewPagerAdapter


abstract class FeedContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(dataHolder: FeedItem, adapter: FeedAdapter)
}

class FeedViewHolder(view: View) : FeedContentViewHolder(view) {
    private val holderBinding = ItemTrimIdeasBinding.bind(view)


    override fun bind(dataHolder: FeedItem, adapter: FeedAdapter) {
        holderBinding.feedItem = dataHolder

        holderBinding.bookmark.setOnClickListener {
            adapter.onBookMarkClick?.invoke(
                adapter.adapterItems[adapterPosition]
            )
        }

        holderBinding.like.setOnClickListener {
            adapter.onLikeClick?.invoke(
                adapter.adapterItems[adapterPosition]
            )
        }

        holderBinding.share.setOnClickListener {
            adapter.onShareClick?.invoke(
                adapter.adapterItems[adapterPosition]
            )
        }

        (holderBinding.viewPager.adapter as? ViewPagerAdapter).let {
            if (it == null) {
                holderBinding.viewPager.adapter = ViewPagerAdapter().apply {
                    setContent(dataHolder.feedItems)
                }
            } else {
                it.setContent(dataHolder.feedItems)
            }
        }
        holderBinding.executePendingBindings()
    }

}