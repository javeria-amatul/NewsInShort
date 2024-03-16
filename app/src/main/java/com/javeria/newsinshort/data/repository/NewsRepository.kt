package com.javeria.newsinshort.data.repository

import com.javeria.newsinshort.data.models.ResourceState
import com.javeria.newsinshort.data.repository.remote.datasource.NewsDataSource
import com.javeria.newsinshort.data.repository.remote.entity.NewsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDataSource: NewsDataSource) {

    suspend fun getNewsHeadlines(country: String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())
            val response = newsDataSource.getNewsHeadlines(country)
            if (response.isSuccessful && response.body()!= null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error"))
            }
        }.catch {e ->
            emit(ResourceState.Error("Error - " + e.localizedMessage))
        }
    }
}