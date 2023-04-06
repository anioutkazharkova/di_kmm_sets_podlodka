package com.azharkova.test_kmm.network

import kotlinx.coroutines.CoroutineDispatcher

expect val uiDispatcher: CoroutineDispatcher
expect val ioDispatcher: CoroutineDispatcher