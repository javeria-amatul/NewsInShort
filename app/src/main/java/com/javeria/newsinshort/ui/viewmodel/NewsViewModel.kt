package com.javeria.newsinshort.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.javeria.newsinshort.AppConstants.COUNTRY
import com.javeria.newsinshort.data.models.ResourceState
import com.javeria.newsinshort.data.repository.NewsRepository
import com.javeria.newsinshort.data.repository.remote.entity.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    private val _news: MutableStateFlow<ResourceState<NewsResponse>> =
        MutableStateFlow(ResourceState.Loading())
    val news: StateFlow<ResourceState<NewsResponse>> = _news

    init {
        getNews(COUNTRY)
    }

    private fun getNews(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsHeadlines(country).collectLatest { response ->
                _news.value = response
            }
        }
    }
}