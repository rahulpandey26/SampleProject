package com.example.sampleproject.home.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.sampleproject.common.util.ApiCallback
import com.example.sampleproject.home.model.UserPostListResponse
import com.example.sampleproject.home.util.UserPostManager

class UserPostListRepository(private val mContext: Context) {

    private val mUserPostManager: UserPostManager = UserPostManager(mContext)
    private val mProgressbarObservable = MutableLiveData<Boolean>()

    companion object {
        private var mUserPostListRepository: UserPostListRepository? = null

        fun getInstance(context: Context): UserPostListRepository? {
            if (mUserPostListRepository == null) {
                mUserPostListRepository = UserPostListRepository(context)
            }
            return mUserPostListRepository
        }
    }

    fun getUserPostList(context: Context, pageNo: Int): MutableLiveData<UserPostListResponse> {
        mProgressbarObservable.value = true
        val userPostListResponse: MutableLiveData<UserPostListResponse> = MutableLiveData()

        mUserPostManager.getUserPostList(object : ApiCallback<UserPostListResponse>(context) {
            override fun onResponseSuccess(response: UserPostListResponse?) {
                userPostListResponse.value = response
                mProgressbarObservable.value = false
            }

            override fun onResponseFailure(errorMessage: String?) {
                userPostListResponse.value = null
                mProgressbarObservable.value = false
            }

        }, pageNo)

        return userPostListResponse
    }

    fun isDataLoading() : MutableLiveData<Boolean>? {
        return mProgressbarObservable
    }
}