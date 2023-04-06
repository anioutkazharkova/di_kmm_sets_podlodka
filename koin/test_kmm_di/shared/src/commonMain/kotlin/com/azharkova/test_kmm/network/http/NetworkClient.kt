package com.azharkova.test_kmm.network.http

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*


expect fun createHttpClient():HttpClient

class NetworkClient {
    val httpClient = createHttpClient()

    suspend inline fun<reified T> request(path: String): Result<T> {
        return try {
            val data = httpClient.get(path)
            print(data)
            val result = data.body<T>()
            Result.success(result)
        }catch (e: Exception) {
            Result.failure(e)
        }

    }
}