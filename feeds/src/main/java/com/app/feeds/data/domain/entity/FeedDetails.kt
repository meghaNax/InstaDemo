package com.app.feeds.data.domain.entity

import android.os.Parcelable
import com.app.feeds.ui.core.adapter.base.AdapterContentElement
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeedDetails constructor(
    val type: String,
    val url: String,
) : AdapterContentElement, Parcelable {

    override fun areContentsTheSame(other: AdapterContentElement): Boolean {
        if (other !is FeedDetails) return false
        return type == other.type
                && url == other.url

    }

}