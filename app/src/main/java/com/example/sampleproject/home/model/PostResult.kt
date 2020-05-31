package com.example.sampleproject.home.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "user_post_result_table")
class PostResult {

    @SerializedName("id")
    @Expose
    val postId: String? = null

    @SerializedName("user_id")
    @Expose
    val userId: String? = null

    @SerializedName("title")
    @Expose
    val title: String? = null

    @SerializedName("body")
    @Expose
    val body: String? = null

    @SerializedName("_links")
    @Expose
    val links: Links? = null

  /*  @PrimaryKey(autoGenerate = true)
    private val id = 0
*/
}
