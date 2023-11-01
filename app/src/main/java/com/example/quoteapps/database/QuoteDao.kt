package com.example.quoteapps.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.quoteapps.model.Quote

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quoteDB")
    suspend fun getQuotes(): List<Quote>

    @Insert
    suspend fun addQuotes(quotes: List<Quote>)

//    @Insert
//    suspend fun insertQuote(quote: Quote)
//
//    @Update
//    suspend fun update(quote: Quote)
}