package com.app.feeds.di

import com.app.feeds.ui.feed.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module{
    viewModel { FeedViewModel(get()) }
}