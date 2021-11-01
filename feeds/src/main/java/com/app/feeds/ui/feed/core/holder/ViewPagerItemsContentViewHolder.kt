package com.app.feeds.ui.feed.core.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.feeds.data.domain.entity.FeedDetails
import com.app.feeds.databinding.ViewPagerItemBinding
import com.app.feeds.ui.feed.core.adapter.ViewPagerAdapter

abstract class ViewPagerItemsContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(dataHolder: FeedDetails, adapter: ViewPagerAdapter)
}

class ViewPageItemsViewHolder(view: View) : ViewPagerItemsContentViewHolder(view) {

    private val holderBinding = ViewPagerItemBinding.bind(view)

    override fun bind(dataHolder: FeedDetails, adapter: ViewPagerAdapter) {
        holderBinding.imageItem = dataHolder
        holderBinding.executePendingBindings()
    }
}