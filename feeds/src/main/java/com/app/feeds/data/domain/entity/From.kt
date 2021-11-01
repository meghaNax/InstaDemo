package com.app.feeds.data.domain.entity

import android.os.Parcelable
import com.app.feeds.ui.core.adapter.base.AdapterContentElement
import kotlinx.parcelize.Parcelize


@Parcelize
class From(
    val id: String,
    val name: String
) : AdapterContentElement, Parcelable {
    override fun areContentsTheSame(other: AdapterContentElement): Boolean {
        if (other !is From) return false

        return name == other.name &&
                id == other.id
    }
}