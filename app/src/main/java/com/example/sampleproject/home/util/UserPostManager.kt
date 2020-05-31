package com.example.sampleproject.home.util


import android.content.Context
import com.example.sampleproject.common.util.ApiCallback
import com.example.sampleproject.common.util.ApiInterface
import com.example.sampleproject.common.util.ApiServiceUtil
import com.example.sampleproject.common.util.Constants
import com.example.sampleproject.home.model.UserPostListResponse
import retrofit2.Call

class UserPostManager(private val mContext: Context) {

    private val mApiInterface: ApiInterface = ApiServiceUtil.getInstance(mContext).getApiInterface()

    fun getUserPostList(callback: ApiCallback<UserPostListResponse> , pageNo: Int) {
        val queries: MutableMap<String, Int> = HashMap()
        queries[Constants.HttpReqParamKey.PAGE] = pageNo
        val userPostListResponseCall: Call<UserPostListResponse> = mApiInterface.getUserPostList(queries)
        userPostListResponseCall.enqueue(callback)
    }

}