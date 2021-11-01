package com.app.feeds.data.domain.entity

import android.os.Parcelable
import com.app.feeds.ui.core.adapter.base.AdapterContentElement
import kotlinx.parcelize.Parcelize


@Parcelize
data class FeedItem(
    val id: String,
    val from: From,
    val message: String,
    val feedItems: List<FeedDetails>,
    val actions: List<Action>,
    val type: String,
    val createdTime: String,
    val updatedTime: String,
    val liked: Boolean = false,
    val bookMarked: Boolean = false
) : AdapterContentElement, Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FeedItem

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun areContentsTheSame(other: AdapterContentElement): Boolean {
        if (other !is FeedItem) return false

        return id == other.id
                && liked == other.liked
                && bookMarked == other.bookMarked
                && from == other.from
                && message == other.message
                && feedItems == other.feedItems
                && actions == other.actions
                && type == other.type
                && createdTime == other.createdTime
                && updatedTime == other.updatedTime
    }


}

