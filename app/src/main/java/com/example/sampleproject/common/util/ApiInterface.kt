package com.example.sampleproject.common.util

import com.example.sampleproject.home.model.UserPostListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiInterface {

    @GET(Constants.POST_LIST)
    fun getUserPostList(@QueryMap(encoded = true) queries: MutableMap<String, Int>): Call<UserPostListResponse>
}