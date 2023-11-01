package com.example.quoteapps.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quoteapps.model.Quote

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDataBase  : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {
        private var INSTANCE: QuoteDataBase? = null

        fun getDatabase(context: Context): QuoteDataBase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        QuoteDataBase::class.java, "quoteDB"
                    )
                        .build()
                }
            }

            return INSTANCE!!
        }

    }
}