package com.app.instaclonedemo.data.remote.entity

import com.google.gson.annotations.SerializedName

class ApiIcon(
    @SerializedName("40px")
    val px40: String? = null,

    @SerializedName("80px")
    val px80: String? = null,

    @SerializedName("120px")
    val px120: String? = null,

    @SerializedName("150px")
    val px150: String? = null

)