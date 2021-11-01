package com.app.feeds.data.domain.entity

import android.os.Parcelable
import com.app.feeds.ui.core.adapter.base.AdapterContentElement
import kotlinx.parcelize.Parcelize

@Parcelize
class Example(var feedItems: List<FeedItem>? = null): AdapterContentElement,Parcelable {
    override fun areContentsTheSame(other: AdapterContentElement): Boolean {
        if (other !is Example) return false

        return feedItems == other.feedItems

    }
}
