package com.example.news_presentation

import com.example.news_domain.model.Article

data class NewsState(
    val isLoading: Boolean = false,
    val newsArticle: List<Article>? = null,
    val error: String = ""
)
