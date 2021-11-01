package com.app.instaclonedemo.data.remote.entity


import com.google.gson.annotations.SerializedName

data class ApiFeedItem(
    @SerializedName("actions")
    val actions: List<ApiAction>? = null,
    @SerializedName("created_time")
    val createdTime: String? = null,
    @SerializedName("from")
    val from: ApiFrom? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("updated_time")
    val updatedTime: String? = null,
    @SerializedName("feedItems")
    val feedItems: List<ApiFeedDetails>? = null,
)