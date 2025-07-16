package com.example.news_domain.useCase

import com.example.common.Resource
import com.example.news_domain.model.Article
import com.example.news_domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetNewsArticleUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(): Flow<Resource<List<Article>>> = flow {
        emit(Resource.Loading())

        try {
            repository.getNewsArticle().collect {
                emit(Resource.Success(data = it))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown Error"))
        }
    }
}