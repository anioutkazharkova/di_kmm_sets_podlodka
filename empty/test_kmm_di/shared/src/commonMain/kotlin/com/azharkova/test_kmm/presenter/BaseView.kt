package com.azharkova.test_kmm.presenter

interface BaseView {
    fun startLoading()

    fun stopLoading()

    fun showInfo(text: String)

    fun showError(text: String)
}