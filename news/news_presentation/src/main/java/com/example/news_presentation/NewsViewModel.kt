package com.example.news_presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Resource
import com.example.news_domain.useCase.GetNewsArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsArticleUseCase: GetNewsArticleUseCase
) : ViewModel() {

    private var _newsState: MutableStateFlow<NewsState> = MutableStateFlow(NewsState())
    val newsState = _newsState.asStateFlow()

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            newsArticleUseCase().collect { resource ->
                when (resource) {
                    is Resource.Error<*> -> {
                        _newsState.value = NewsState(
                            isLoading = false,
                            error = resource.message ?: "Unknown Error"
                        )
                    }

                    is Resource.Loading<*> -> {
                        _newsState.value = NewsState(
                            isLoading = true
                        )
                    }
                    is Resource.Success<*> -> {
                        _newsState.value = NewsState(
                            isLoading = false,
                            newsArticle = resource.data ?: emptyList()
                        )
                    }
                }
            }

        }
    }
}