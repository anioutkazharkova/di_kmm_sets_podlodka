package com.azharkova.test_kmm

import com.azharkova.test_kmm.network.http.NetworkClient
import com.azharkova.test_kmm.presenter.NewsViewModel
import com.azharkova.test_kmm.service.NewsService
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.dsl.module

class KoinDI : KoinComponent {
    val serviceModule = module {
        single { NetworkClient() }
        single { NewsService(get()) }
    }

    val usecaseModule = module {
        factory {
            NewsUseCase(get())
        }
    }

    val vmModule = module {
        factory<NewsViewModel> { NewsViewModel(get()) }
    }

    fun start() = startKoin {
        modules(listOf(serviceModule, usecaseModule, vmModule))
    }
}