package com.javeria.newsinshort.data.repository.remote.api

import com.javeria.newsinshort.AppConstants.API_KEY
import com.javeria.newsinshort.data.repository.remote.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>

//    https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=0e7a75616c5b41fbbdbadf111f2567d2
}