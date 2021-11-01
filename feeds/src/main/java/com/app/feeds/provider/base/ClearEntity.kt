package com.app.feeds.provider.base

interface ClearEntity<T> {
    fun emptyEntity() : T
}