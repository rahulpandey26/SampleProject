package com.example.sampleproject.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sampleproject.home.model.PostResult

@Dao
interface UserPostDao {

    @Query("Select * from user_post_result_table")
    fun getAllUserPost(): LiveData<List<PostResult?>?>?

    @Insert
    fun insert(note: PostResult?)

    @Update
    fun update(note: PostResult?)

    @Delete
    fun delete(note: PostResult?)

    @Query("DELETE FROM user_post_result_table")
    fun deleteAll()
}