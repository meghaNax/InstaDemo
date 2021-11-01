package com.app.instaclonedemo.data.remote.entity


import com.google.gson.annotations.SerializedName

data class ApiFrom(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)