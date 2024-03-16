package com.javeria.newsinshort.data.repository.remote.entity

data class NewsResponse(val status: String, val totalResults: Int, val articles: List<Article>)

data class Article(val title: String, val author: String?, val publishedAt: String, val source: Source, val url: String)

data class Source(val id: String?, val name: String)