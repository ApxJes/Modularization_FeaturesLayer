package com.example.news_data.mapper

import com.example.news_data.dto.ArticleDto
import com.example.news_domain.model.Article

fun ArticleDto.toDomainArticle(): Article {
    return Article(
        author = author ?: "Unknown",
        content = content ?: "Unknown",
        description = description ?: "Unknown",
        publishedAt = publishedAt ?: "Unknown",
        title = title ?: "Unknown",
        url = url ?: "Unknown",
        urlToImage = urlToImage ?: "Unknown"
    )
}