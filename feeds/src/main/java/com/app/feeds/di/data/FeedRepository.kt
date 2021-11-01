package com.app.feeds.di.data

import com.app.feeds.data.domain.entity.FeedItem

interface FeedRepository {
    suspend fun loadFeed(): Result<List<FeedItem>>
}

