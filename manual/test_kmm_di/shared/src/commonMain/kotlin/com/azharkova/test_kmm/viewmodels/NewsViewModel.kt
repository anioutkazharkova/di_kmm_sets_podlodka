package com.azharkova.test_kmm.viewmodels

import com.azharkova.test_kmm.data.NewsList
import com.azharkova.test_kmm.di.DI
import com.azharkova.test_kmm.network.ioDispatcher
import com.azharkova.test_kmm.service.NewsService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel() : BaseViewModel(), NewsVM {
    var newsFlow = MutableStateFlow<NewsList?>(null)
    val newsUseCase: NewsUseCase by lazy {
        DI.newsUseCase
    }

    override fun loadNews() {
        scope.launch {
            val result = withContext(ioDispatcher) {
                newsUseCase.invoke(Unit)
            }
            result.getOrNull()?.let {
                newsFlow.tryEmit(it)
            }
        }
    }
}

