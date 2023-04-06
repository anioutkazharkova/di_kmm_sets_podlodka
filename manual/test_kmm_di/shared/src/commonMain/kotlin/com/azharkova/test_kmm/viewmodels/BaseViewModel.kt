package com.azharkova.test_kmm.viewmodels

import com.azharkova.test_kmm.network.uiDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

open class BaseViewModel{
    val job = SupervisorJob()
    protected var scope: CoroutineScope = CoroutineScope(uiDispatcher + job)
}