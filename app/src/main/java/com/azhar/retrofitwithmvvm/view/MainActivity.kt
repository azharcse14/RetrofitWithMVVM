package com.azhar.retrofitwithmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.azhar.retrofitwithmvvm.R
import com.azhar.retrofitwithmvvm.model.api.QuoteService
import com.azhar.retrofitwithmvvm.model.api.RetrofitHelper
import com.azhar.retrofitwithmvvm.model.repository.QuoteRepository
import com.azhar.retrofitwithmvvm.view_model.MainViewModel
import com.azhar.retrofitwithmvvm.view_model.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            val quotaList = it.results
            if (quotaList != null){
                quotaList.forEach{
                    Log.d("quota", it.content)
                }
            }
        })
    }
}