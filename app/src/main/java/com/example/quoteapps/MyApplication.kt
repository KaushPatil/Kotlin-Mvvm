package com.example.quoteapps

import android.app.Application
import com.example.quoteapps.repository.QuoteRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication: Application() {

    @Inject
    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
    }

}