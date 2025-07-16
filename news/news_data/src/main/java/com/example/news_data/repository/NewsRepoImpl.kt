package com.example.news_data.repository

import com.example.news_data.mapper.toDomainArticle
import com.example.news_data.network.NewsApiService
import com.example.news_domain.model.Article
import com.example.news_domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(
    private val newsApiService: NewsApiService
) : NewsRepository {
    override suspend fun getNewsArticle(): Flow<List<Article>> = flow {
        val newsArticle = newsApiService.getNewsArticle().articles
            ?.mapNotNull { it?.toDomainArticle() }
            ?: emptyList()
        emit(newsArticle)
    }.catch { e ->
        throw e
        emit(emptyList())
    }
}