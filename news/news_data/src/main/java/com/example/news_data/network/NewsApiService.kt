package com.example.news_data.network

import com.example.core.Constants.API_KEY
import com.example.news_data.dto.NewsResponse
import retrofit2.http.Query

interface NewsApiService {

    suspend fun getNewsArticle(
        @Query("q") query: String = "Business",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}