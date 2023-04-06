package com.azharkova.test_kmm.viewmodels

import com.azharkova.test_kmm.data.NewsList

interface NewsView : BaseView {
    fun setupData(data: NewsList) = Unit
}