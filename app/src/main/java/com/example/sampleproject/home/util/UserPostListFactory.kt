package com.example.sampleproject.home.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sampleproject.home.viewModel.UserPostListViewModel

class UserPostListFactory(private val mContext: Context, private val mPageNo: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  UserPostListViewModel(mContext, mPageNo) as T;
    }
}