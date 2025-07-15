package com.example.news_domain.repository

import com.example.news_domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsArticle(): Flow<List<Article>>
}