package com.example.sampleproject.home.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Meta {

    @SerializedName("success")
    @Expose
    val success = false

    @SerializedName("code")
    @Expose
    val code = 0

    @SerializedName("message")
    @Expose
    val message: String? = null

    @SerializedName("totalCount")
    @Expose
    val totalCount = 0

    @SerializedName("pageCount")
    @Expose
    val pageCount = 0

    @SerializedName("currentPage")
    @Expose
    val currentPage = 0

    @SerializedName("perPage")
    @Expose
    val perPage = 0

    @SerializedName("rateLimit")
    @Expose
    val rateLimit: RateLimit? = null

}
