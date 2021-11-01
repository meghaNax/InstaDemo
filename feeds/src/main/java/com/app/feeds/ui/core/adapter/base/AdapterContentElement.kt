package com.app.feeds.ui.core.adapter.base

interface AdapterContentElement {

    fun areContentsTheSame(other: AdapterContentElement): Boolean
}