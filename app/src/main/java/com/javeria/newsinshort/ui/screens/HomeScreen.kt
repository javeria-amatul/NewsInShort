package com.javeria.newsinshort.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.javeria.newsinshort.data.models.ResourceState
import com.javeria.newsinshort.data.repository.remote.entity.Article
import com.javeria.newsinshort.ui.components.Loader
import com.javeria.newsinshort.ui.components.NewRowComponent
import com.javeria.newsinshort.ui.viewmodel.NewsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(newsViewModel: NewsViewModel = hiltViewModel()) {
    val newRes by newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f) {
        100
    }
    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) {page ->
        when(newRes) {
            is ResourceState.Loading -> {
                Log.d("View", "Loading")
                Loader()
            }
            is ResourceState.Success -> {
                val response = (newRes as ResourceState.Success).data
                Log.d("View", "Success" + response.totalResults)
                if (response.articles.isNotEmpty()) {
                    NewRowComponent(page, response.articles.get(page))
                }
            }

            is ResourceState.Error -> {
                val error = (newRes as ResourceState.Error)
                Log.d("View", "Error$error")
            }
        }
    }
}



@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}