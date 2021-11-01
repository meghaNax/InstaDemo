package com.app.instaclonedemo.data.remote.entity

import com.google.gson.annotations.SerializedName


data class ApiFeedDetails(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null,
)