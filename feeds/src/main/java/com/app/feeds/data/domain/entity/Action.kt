package com.app.feeds.data.domain.entity

import android.os.Parcelable
import com.app.feeds.ui.core.adapter.base.AdapterContentElement
import kotlinx.android.parcel.Parcelize

@Parcelize
class Action(
    val name: String,
    val link: String
) : AdapterContentElement, Parcelable {
    override fun areContentsTheSame(other: AdapterContentElement): Boolean {
        if (other !is Action) return false

        return name == other.name
                && link == other.link
    }
}
