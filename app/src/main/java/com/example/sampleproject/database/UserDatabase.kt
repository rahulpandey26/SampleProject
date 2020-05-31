package com.example.sampleproject.database

import android.content.Context
import android.os.AsyncTask
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


abstract class UserDatabase: RoomDatabase() {

    abstract fun userPostDao(): UserPostDao?

   companion object {
       private var mInstance: UserDatabase? = null
       fun getInstance(context: Context): UserDatabase? {
           if (mInstance == null) {
               mInstance = Room.databaseBuilder(context.applicationContext, UserDatabase::class.java,
                   "user_database").fallbackToDestructiveMigration()
                   .addCallback(roomCallBack)
                   .build()
           }
           return mInstance
       }

       private val roomCallBack: Callback = object : Callback() {
           override fun onCreate(db: SupportSQLiteDatabase) {
               super.onCreate(db)
               PopulateDbAsyncTask(mInstance).execute()
           }
       }
   }

    private class PopulateDbAsyncTask internal constructor(noteDataBase: UserDatabase?) :
        AsyncTask<Void?, Void?, Void?>() {
        private val userPostDao: UserPostDao = noteDataBase?.userPostDao()!!

        override fun doInBackground(vararg params: Void?): Void? {
            return null
        }
    }
}