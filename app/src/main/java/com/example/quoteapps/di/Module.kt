package com.example.quoteapps.di

import android.content.Context
import androidx.room.Room
import com.example.quoteapps.api.QuoteServiceApi
import com.example.quoteapps.database.QuoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    private val BASE_URL = "https://api.quotable.io/"

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): QuoteDataBase {
        return Room.databaseBuilder(context, QuoteDataBase::class.java, "quoteDB").build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApi(retrofit: Retrofit): QuoteServiceApi{
        return retrofit.create(QuoteServiceApi::class.java)
    }
}