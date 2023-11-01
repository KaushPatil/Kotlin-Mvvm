package com.example.quoteapps.api

import com.example.quoteapps.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteServiceApi {

    @GET("quotes")
    //Base url + end point + page
    suspend fun getQuotes(@Query("page") page:Int): Response<QuoteList>
}