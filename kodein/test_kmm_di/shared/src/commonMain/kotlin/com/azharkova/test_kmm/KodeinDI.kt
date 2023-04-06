package com.azharkova.test_kmm
import com.azharkova.test_kmm.network.http.NetworkClient
import com.azharkova.test_kmm.presenter.NewsUseCase
import com.azharkova.test_kmm.presenter.NewsViewModel
import com.azharkova.test_kmm.service.NewsService
import org.kodein.di.*

class KodeinDI {

    val serviceModule = org.kodein.di.DI.Module("service") {
        bindSingleton{
            NetworkClient()
        }
        bindSingleton {
            NewsService(instance())
        }
    }

    val viewModels = org.kodein.di.DI.Module("viewModels") {
        bindProvider {
            NewsViewModel(instance())
        }
    }
    val useCases = org.kodein.di.DI.Module("usecases") {
        bindProvider {
           NewsUseCase(instance())
        }
    }

    val di = org.kodein.di.DI {
        import(serviceModule)
        import(useCases)
        import(viewModels)
    }
}

object DIFactory {
    val di = KodeinDI().di
    val diDirect = di.direct

    inline fun<reified T> resolve():T? {
        return diDirect.instance()
    }

    inline fun<reified T:Any> resolveDirect():T? {
        return diDirect.instance()
    }
}