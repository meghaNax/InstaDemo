package com.app.feeds.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.app.feeds.data.domain.entity.FeedItem
import com.app.feeds.provider.FeedProvider


class FeedViewModel(private val provider: FeedProvider) : ViewModel() {

    val feed: LiveData<List<FeedItem>>
        get() = provider.feeds

    val searchFeed: MutableLiveData<String> = MutableLiveData()
    private val queryObserver = Observer<String> {
        provider.filterFeedFor(it)
    }


    init {
        provider.execute()
        searchFeed.observeForever(queryObserver)
    }

    fun bookMarkedItem(feedItem: FeedItem) {
        provider.bookMarkedItem(feedItem)
    }

    fun likeItem(feedItem: FeedItem) {
        provider.likeItem(feedItem)
    }

    override fun onCleared() {
        super.onCleared()
        searchFeed.observeForever(queryObserver)
    }
}