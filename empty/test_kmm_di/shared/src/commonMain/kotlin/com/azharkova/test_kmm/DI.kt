package com.azharkova.test_kmm

import com.azharkova.test_kmm.network.http.NetworkClient
import com.azharkova.test_kmm.service.NewsService

object DI {
    val httpClient: NetworkClient by lazy {
        NetworkClient()
    }

    val newsService: NewsService by lazy {
        NewsService(httpClient)
    }
}
