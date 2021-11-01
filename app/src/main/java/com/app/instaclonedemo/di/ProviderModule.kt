package com.app.instaclonedemo.di


import com.app.instaclonedemo.data.mapper.FeedItemMapper
import com.google.gson.Gson
import org.koin.dsl.module

val providerModule = module {
    factory { FeedItemMapper() }
    single { Gson() }
}