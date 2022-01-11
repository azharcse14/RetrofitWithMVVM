package com.azhar.retrofitwithmvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azhar.retrofitwithmvvm.model.data.QuoteList
import com.azhar.retrofitwithmvvm.model.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }

    val quotes: LiveData<QuoteList>
        get() = repository.quotes
}