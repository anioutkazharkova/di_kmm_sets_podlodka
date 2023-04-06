package com.azharkova.test_kmm.presenter

import com.azharkova.test_kmm.network.uiDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

open class ViewModel{
    val job = SupervisorJob()
    protected var scope: CoroutineScope = CoroutineScope(uiDispatcher + job)
}