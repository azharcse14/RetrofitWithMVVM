package com.azhar.retrofitwithmvvm.model.api

import com.azhar.retrofitwithmvvm.model.data.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int) : Response<QuoteList>
}