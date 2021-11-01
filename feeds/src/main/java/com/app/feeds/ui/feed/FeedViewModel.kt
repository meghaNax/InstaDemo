package com.app.feeds.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.feeds.data.domain.entity.FeedItem
import com.app.feeds.provider.FeedProvider


class FeedViewModel(private val provider: FeedProvider) : ViewModel() {

    val feed: LiveData<List<FeedItem>>
        get() = provider.feeds

    init {
        provider.execute()
    }

    fun bookMarkedItem(feedItem: FeedItem){
        provider.bookMarkedItem(feedItem)
    }

    fun likeItem(feedItem: FeedItem){
        provider.likeItem(feedItem)
    }
}