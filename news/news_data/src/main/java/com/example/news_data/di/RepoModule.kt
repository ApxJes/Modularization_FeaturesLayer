package com.example.news_data.di

import com.example.news_data.repository.NewsRepoImpl
import com.example.news_domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    @Singleton
    abstract fun provideRepo(
        repoImpl: NewsRepoImpl
    ): NewsRepository
}