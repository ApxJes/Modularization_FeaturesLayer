package com.example.news_domain.di

import com.example.news_domain.repository.NewsRepository
import com.example.news_domain.useCase.GetNewsArticleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NewsDomainModule {

    @Provides
    @Singleton
    fun provideNewsUseCase(newsRepository: NewsRepository): GetNewsArticleUseCase {
        return GetNewsArticleUseCase(newsRepository)
    }
}