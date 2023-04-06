package com.azharkova.test_kmm

import kotlin.reflect.KClass

object KoinDIFactory {
    val di by lazy {
        KoinDI().apply {
            start()
        }
    }

    fun<T:Any> KoinDIFactory.resolve(clazz: KClass<*>):T? {
        return di.getKoin().get(clazz)
    }
}
