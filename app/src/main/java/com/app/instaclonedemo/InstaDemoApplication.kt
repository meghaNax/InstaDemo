package com.app.instaclonedemo

import android.app.Application
import com.app.instaclonedemo.di.providerModule
import com.app.instaclonedemo.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class InstaDemoApplication : Application() {
    val modules = listOf(
        providerModule,
        repositoryModule,
        com.app.feeds.di.viewModelModule,
        com.app.feeds.di.providerModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@InstaDemoApplication)
            modules(modules)
        }
    }
}