package com.azharkova.test_kmm

import com.azharkova.test_kmm.presenter.BaseView
import com.azharkova.test_kmm.presenter.NewsView
import com.azharkova.test_kmm.presenter.NewsViewModel
import com.azharkova.test_kmm.presenter.ViewModel
import org.kodein.di.instance

object VMFactory {
    fun createVM(type: BaseView):ViewModel? {
       return when(type) {
            is NewsView -> DIFactory.diDirect.instance<NewsViewModel>()
           else -> null
       }
        return null
    }

    inline fun<reified T:ViewModel> getVM():T? {
        return DIFactory.diDirect.instance() as? T
    }
}
