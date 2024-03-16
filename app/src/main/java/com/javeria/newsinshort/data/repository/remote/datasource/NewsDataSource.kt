package com.javeria.newsinshort.data.repository.remote.datasource

import com.javeria.newsinshort.data.repository.remote.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

    suspend fun getNewsHeadlines(country: String): Response<NewsResponse>
}