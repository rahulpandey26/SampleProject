package com.example.sampleproject.database

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.sampleproject.home.model.PostResult

class DbRepository(application: Application) {

    private var mUserPostDao: UserPostDao? = null
    private var mUserPostResult: LiveData<List<PostResult?>?>? = null

    init {
        val userDataBase: UserDatabase = UserDatabase.getInstance(application)!!
        mUserPostDao = userDataBase.userPostDao()
        mUserPostResult = mUserPostDao?.getAllUserPost()
    }

    fun insert(postResult: PostResult) {
        InsertUserPostAsyncTask(mUserPostDao, DataBaseOperationType.INSERT).execute(postResult)
    }

    fun update(postResult: PostResult) {
        InsertUserPostAsyncTask(mUserPostDao, DataBaseOperationType.UPDATE).execute(postResult)
    }

    fun delete(postResult: PostResult) {
        InsertUserPostAsyncTask(mUserPostDao, DataBaseOperationType.DELETE).execute(postResult)
    }

    fun deleteAll() {
        InsertUserPostAsyncTask(mUserPostDao, DataBaseOperationType.DELETEALL).execute()
    }

    fun getAllUserPost(): LiveData<List<PostResult?>?>? {
        return mUserPostResult
    }

    private class InsertUserPostAsyncTask internal constructor(
        userPostDao: UserPostDao?,  dataBaseOperationType: DataBaseOperationType) :
        AsyncTask<PostResult?, Void?, Void?>() {

        private val mUserPostDao: UserPostDao? = userPostDao
        private val mDataBaseOperationType: DataBaseOperationType = dataBaseOperationType

        override fun doInBackground(vararg postResult: PostResult?): Void? {
            when (mDataBaseOperationType) {
                DataBaseOperationType.INSERT -> mUserPostDao?.insert(postResult[0])
                DataBaseOperationType.UPDATE -> mUserPostDao?.update(postResult[0])
                DataBaseOperationType.DELETE -> mUserPostDao?.delete(postResult[0])
                DataBaseOperationType.DELETEALL -> mUserPostDao?.deleteAll()
            }
            return null
        }
    }
}