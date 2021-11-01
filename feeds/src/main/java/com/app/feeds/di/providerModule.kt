package com.app.feeds.di

import com.app.feeds.provider.FeedProvider
import org.koin.dsl.module

val providerModule = module {
    factory { FeedProvider(get()) }
}