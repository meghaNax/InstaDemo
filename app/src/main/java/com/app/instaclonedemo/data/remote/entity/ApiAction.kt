package com.app.instaclonedemo.data.remote.entity


import com.google.gson.annotations.SerializedName

data class ApiAction(
    @SerializedName("link")
    val link: String? = null,
    @SerializedName("name")
    val name: String? = null
)