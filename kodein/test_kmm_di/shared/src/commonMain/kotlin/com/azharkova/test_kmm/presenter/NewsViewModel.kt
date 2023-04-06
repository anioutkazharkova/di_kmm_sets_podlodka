package com.azharkova.test_kmm.presenter

import com.azharkova.test_kmm.data.NewsList
import com.azharkova.test_kmm.network.ioDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel(private val newsUseCase: NewsUseCase) : ViewModel() {
    var newsFlow = MutableStateFlow<NewsList?>(null)

    fun loadNews() {
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

