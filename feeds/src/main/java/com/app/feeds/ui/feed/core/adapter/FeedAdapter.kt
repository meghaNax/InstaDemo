package com.app.feeds.ui.feed.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app.feeds.R
import com.app.feeds.data.domain.entity.FeedItem
import com.app.feeds.ui.core.adapter.base.BaseRecyclerAdapter
import com.app.feeds.ui.feed.core.holder.FeedViewHolder


class FeedAdapter : BaseRecyclerAdapter<FeedViewHolder, FeedItem>() {
    var onBookMarkClick: ((FeedItem) -> Unit)? = null
    var onLikeClick: ((FeedItem) -> Unit)? = null
    var onShareClick: ((FeedItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_trim_ideas, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(adapterItems[position], this)
    }
}

