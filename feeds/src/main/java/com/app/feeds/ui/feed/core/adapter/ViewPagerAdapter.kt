package com.app.feeds.ui.feed.core.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app.feeds.R
import com.app.feeds.data.domain.entity.FeedDetails
import com.app.feeds.ui.core.adapter.base.BaseRecyclerAdapter
import com.app.feeds.ui.feed.core.holder.ViewPageItemsViewHolder


class ViewPagerAdapter : BaseRecyclerAdapter<ViewPageItemsViewHolder, FeedDetails>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageItemsViewHolder =
        ViewPageItemsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_pager_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewPageItemsViewHolder, position: Int) {
        holder.bind(adapterItems[position], this)
    }
}