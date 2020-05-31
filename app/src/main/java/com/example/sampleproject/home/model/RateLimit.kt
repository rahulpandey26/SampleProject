package com.example.sampleproject.home.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RateLimit {

    @SerializedName("limit")
    @Expose
    val limit = 0

    @SerializedName("remaining")
    @Expose
    val remaining = 0

    @SerializedName("reset")
    @Expose
    val reset = 0

}
