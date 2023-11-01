package com.example.quoteapps.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quoteDB")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val quoteId: Int,
    @ColumnInfo(name = "id")
    val _id: String,
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,

)