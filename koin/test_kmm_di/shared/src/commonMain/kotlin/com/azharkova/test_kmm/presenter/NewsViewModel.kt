package com.azharkova.test_kmm.presenter

import com.azharkova.test_kmm.DI
import com.azharkova.test_kmm.NewsUseCase
import com.azharkova.test_kmm.data.NewsList
import com.azharkova.test_kmm.network.ioDispatcher
import com.azharkova.test_kmm.service.NewsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(private val useCase: NewsUseCase) : ViewModel() {
    var newsFlow = MutableStateFlow<NewsList?>(null)

    fun loadNews() {
        scope.launch {
            val result = withContext(ioDispatcher) {
                useCase.invoke(Unit)
            }
            result.getOrNull()?.let {
                newsFlow.tryEmit(it)
            }
        }
    }
}

