package com.example.sampleproject.common.util

import android.content.Context
import android.content.SharedPreferences

class SavedPreferences(context: Context) {

    private var sharedPreferences: SharedPreferences? = null

    init {
        sharedPreferences = context.getSharedPreferences(user_perf, Context.MODE_PRIVATE)
    }

    companion object {

        private const val user_perf = "UserData"
        private var savePreferences: SavedPreferences? = null

        fun getInstance(context: Context): SavedPreferences {
            if (savePreferences == null) {
                savePreferences = SavedPreferences(context)
            }
            return savePreferences as SavedPreferences
        }
    }

    fun setData(key: String?, value: String?): Boolean {
        return sharedPreferences!!.edit().putString(key, value).commit()
    }

    fun getData(key: String?): String? {
        return if (!sharedPreferences!!.contains(key)) {
            ""
        } else {
            this.sharedPreferences?.getString(key, "")
        }
    }
}