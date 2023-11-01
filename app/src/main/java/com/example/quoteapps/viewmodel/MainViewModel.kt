package com.example.quoteapps.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quoteapps.model.QuoteList
import com.example.quoteapps.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuote(1)
        }
    }

    val quotes: LiveData<QuoteList>
        get() = repository.quotes


//    fun getQuote(): LiveData<List<Quote>>{
//        return repository.getQuote()
//
//    }
//
//    fun insert(quote: Quote){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.insert(quote)
//        }
//    }


}