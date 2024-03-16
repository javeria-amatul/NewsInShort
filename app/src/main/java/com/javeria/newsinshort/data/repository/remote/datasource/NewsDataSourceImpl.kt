package com.javeria.newsinshort.data.repository.remote.datasource

import com.javeria.newsinshort.data.repository.remote.api.ApiService
import com.javeria.newsinshort.data.repository.remote.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(private val apiService: ApiService): NewsDataSource {

    override suspend fun getNewsHeadlines(country: String): Response<NewsResponse> {
        return apiService.getNewsHeadline(country = country)
    }
}