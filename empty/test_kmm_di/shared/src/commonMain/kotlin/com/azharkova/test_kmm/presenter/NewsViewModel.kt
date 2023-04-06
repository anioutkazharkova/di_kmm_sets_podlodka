package com.azharkova.test_kmm.presenter

import com.azharkova.test_kmm.DI
import com.azharkova.test_kmm.data.NewsList
import com.azharkova.test_kmm.network.ioDispatcher
import com.azharkova.test_kmm.service.NewsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel() : BaseViewModel(), NewsVM {
    var newsFlow = MutableStateFlow<NewsList?>(null)
    val newsService: NewsService by lazy {
        DI.newsService
    }

    override fun loadNews() {
        scope.launch {
            val result = withContext(ioDispatcher) {
                newsService.loadNews()
            }
            result.getOrNull()?.let {
                newsFlow.tryEmit(it)
            }
        }
    }
}

