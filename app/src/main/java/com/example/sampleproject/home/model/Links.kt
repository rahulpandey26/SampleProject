package com.example.sampleproject.home.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links {

    @SerializedName("self")
    @Expose
    val self: Self? = null

    @SerializedName("edit")
    @Expose
    val edit: Edit? = null

}
