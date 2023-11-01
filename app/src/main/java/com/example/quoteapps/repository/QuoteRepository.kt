package com.example.quoteapps.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quoteapps.api.QuoteServiceApi
import com.example.quoteapps.database.QuoteDataBase
import com.example.quoteapps.model.QuoteList
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quoteServiceApi: QuoteServiceApi,
                      private val quoteDataBase: QuoteDataBase) {

//    fun getQuote(): LiveData<List<Quote>>{
//        return quoteDao.getQuote()
//    }
//
//    suspend fun insert(quote: Quote){
//        quoteDao.insertQuote(quote)
//    }
//
//    suspend fun update(quote: Quote){
//        quoteDao.update(quote)
//    }

    private val quoteLiveData = MutableLiveData<QuoteList>()
    val quotes: LiveData<QuoteList>
        get() = quoteLiveData
    suspend fun getQuote(page: Int){
        val result = quoteServiceApi.getQuotes(page)
        if(result?.body() != null){
            quoteDataBase.quoteDao().addQuotes(result.body()!!.results)
            quoteLiveData.postValue(result.body())
        }
    }
}