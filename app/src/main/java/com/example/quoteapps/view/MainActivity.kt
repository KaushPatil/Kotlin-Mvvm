package com.example.quoteapps.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quoteapps.R
import com.example.quoteapps.databinding.MainActivityBinding
import com.example.quoteapps.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var binding: MainActivityBinding
    lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setAdapter()
        observeLiveData()
    }

    private fun observeLiveData() {
        mainViewModel.quotes.observe(this, Observer {
            //set data to adapter
            adapter.submitList(it.results)
        })

    }

    private fun setAdapter() {
        adapter = QuoteAdapter()
        binding.quoteRecyclerView.adapter = adapter
    }

}