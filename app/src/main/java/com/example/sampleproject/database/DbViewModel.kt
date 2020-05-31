package com.example.sampleproject.database

import android.app.Application
import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.sampleproject.home.model.PostResult


class DbViewModel(application: Application) : AndroidViewModel(application) {

    private var mDbRepository: DbRepository? = null
    private var mUserAllPost: LiveData<List<PostResult?>?>? = null

    init {
        mDbRepository = DbRepository(getApplication())
        mUserAllPost = mDbRepository!!.getAllUserPost()
    }

    fun getAllUserPost(): LiveData<List<PostResult?>?>? {
        return mUserAllPost
    }

    fun insert(postResult: PostResult) {
        mDbRepository?.insert(postResult)
    }

    fun update(postResult: PostResult) {
        mDbRepository?.update(postResult)
    }

    fun delete(postResult: PostResult) {
        mDbRepository?.delete(postResult)
    }

    fun deleteAll() {
        mDbRepository?.deleteAll()
    }
}