package com.app.feeds.provider

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.feeds.data.domain.entity.FeedItem
import com.app.feeds.di.data.FeedRepository
import com.app.feeds.provider.base.AsyncProvider
import com.app.feeds.provider.base.Parameters
import kotlinx.coroutines.launch
import org.koin.ext.scope

class FeedProvider(private val feedRepository: FeedRepository) : AsyncProvider() {

    var tempList: List<FeedItem> = emptyList()

    private val _feeds = MutableLiveData<List<FeedItem>>()
    val feeds: LiveData<List<FeedItem>> = _feeds

    private val _feedError = MutableLiveData<Throwable>()
    val feedError: LiveData<Throwable> = _feedError

    override fun executeCore(params: Parameters?) {
        setState(State.BUSY)

        scope.launch {
            feedRepository.loadFeed()
                .onSuccess { feeds ->
                    setState(State.FINISHED)
                    _feeds.postValue(feeds)
                    tempList = feeds
                }
                .onFailure {
                    setState(State.FAILED)
                    _feedError.postValue(it)
                }
        }
    }

    fun bookMarkedItem(feedItem: FeedItem) {
        scope.launch {
            _feeds.value?.toMutableList()?.let {
                it[it.indexOf(feedItem)] = feedItem.copy(bookMarked = !feedItem.bookMarked)
                _feeds.postValue(it)
            }
        }
    }

    fun likeItem(feedItem: FeedItem) {
        scope.launch {
            _feeds.value?.toMutableList()?.let {
                it[it.indexOf(feedItem)] = feedItem.copy(liked = !feedItem.liked)
                _feeds.postValue(it)
            }
        }
    }

    fun filterFeedFor(query: String?) {
        scope.launch {
            if (query.isNullOrBlank()) {
                _feeds.postValue(tempList)
            } else {
                _feeds.postValue(tempList.filter {
                    it.message.contains(
                        query,
                        true
                    ) || it.from.name.contains(query, true)
                })
            }
        }
    }

}