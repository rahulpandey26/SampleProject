package com.example.sampleproject.home.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sampleproject.home.model.UserPostListResponse
import com.example.sampleproject.home.repository.UserPostListRepository


class UserPostListViewModel(private val mContext: Context, private  val mPageNo: Int) : ViewModel() {

    private var mUserPostListMutableLiveData: MutableLiveData<UserPostListResponse>? = null
    private var mUserPostListRepository: UserPostListRepository? = null
    private var mProgressVisibility: MutableLiveData<Boolean>? = null

    fun init() {
        mUserPostListRepository = UserPostListRepository.getInstance(mContext)

        if (mUserPostListMutableLiveData == null) {
            mUserPostListMutableLiveData = mUserPostListRepository?.getUserPostList(mContext, mPageNo)
        }

    }

    fun getUserPostListRepository(): LiveData<UserPostListResponse?>? {
        return mUserPostListMutableLiveData
    }

    fun getProgress(): LiveData<Boolean?>? {
        mProgressVisibility = mUserPostListRepository?.isDataLoading()
        return mProgressVisibility
    }
}