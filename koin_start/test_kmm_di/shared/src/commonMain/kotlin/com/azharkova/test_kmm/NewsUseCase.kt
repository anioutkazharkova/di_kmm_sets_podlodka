package com.azharkova.test_kmm

import com.azharkova.test_kmm.data.NewsList
import com.azharkova.test_kmm.network.ioDispatcher
import com.azharkova.test_kmm.presenter.BaseUseCase
import com.azharkova.test_kmm.service.NewsService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class NewsUseCase (private val newsService: NewsService): BaseUseCase<Unit, NewsList?>() {
    override suspend fun execute(param: Unit): NewsList? {
       return try {
           newsService.loadNews()?.getOrNull()
       }catch (e: Exception) {
           throw e
       }
    }
}