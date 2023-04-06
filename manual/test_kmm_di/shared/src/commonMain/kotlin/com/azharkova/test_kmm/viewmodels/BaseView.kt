package com.azharkova.test_kmm.viewmodels

interface BaseView {
    fun startLoading() = Unit

    fun stopLoading() = Unit

    fun showInfo(text: String) = Unit

    fun showError(text: String) = Unit
}