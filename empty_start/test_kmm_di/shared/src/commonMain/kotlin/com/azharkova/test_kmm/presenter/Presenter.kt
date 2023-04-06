package com.azharkova.test_kmm.presenter

interface Presenter {
    fun attach(view: BaseView)

    fun detach()
}