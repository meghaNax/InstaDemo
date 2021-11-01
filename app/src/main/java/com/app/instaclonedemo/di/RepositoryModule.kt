package com.app.instaclonedemo.di

import com.app.feeds.di.data.FeedRepository
import com.app.instaclonedemo.data.repo.FeedRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<FeedRepository> { FeedRepositoryImpl(get(), get(), get()) }
}