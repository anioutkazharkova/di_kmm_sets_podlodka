package com.azharkova.test_kmm.di

import com.azharkova.test_kmm.network.http.NetworkClient
import com.azharkova.test_kmm.service.NewsService
import com.azharkova.test_kmm.viewmodels.NewsUseCase

object DI {
    val httpClient: NetworkClient by lazy {
        NetworkClient()
    }

    val newsService: NewsService by lazy {
        NewsService(httpClient)
    }
    val newsUseCase: NewsUseCase by lazy {
        NewsUseCase(newsService)
    }
}


object ServiceLocator {
    var services:MutableMap<String,Any> = mutableMapOf()

    inline fun<reified T:Any> add(service: T) {
        (T::class.qualifiedName)?.let {
            services.put(it,service)
        }
    }

    inline fun<reified T:Any> service():T?  {
       return ((T::class.qualifiedName)?.let {
           services[it]
        } as? T) ?: null
    }
}

