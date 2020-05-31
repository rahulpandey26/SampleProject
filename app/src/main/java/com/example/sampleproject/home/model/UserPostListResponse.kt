package com.example.sampleproject.home.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserPostListResponse {

    @SerializedName("_meta")
    @Expose
    val meta: Meta? = null

    @SerializedName("result")
    @Expose
    val result: List<PostResult>? = null
}