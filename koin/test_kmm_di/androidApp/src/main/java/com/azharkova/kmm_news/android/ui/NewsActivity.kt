package com.azharkova.news.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.azharkova.kmm_news.android.R
import com.azharkova.kmm_news.android.ui.NewsListScreen
import com.azharkova.test_kmm.*
import com.azharkova.test_kmm.KoinDIFactory.resolve

import com.azharkova.test_kmm.presenter.NewsView
import com.azharkova.test_kmm.presenter.NewsViewModel

class NewsActivity : AppCompatActivity(), NewsView {
    private val vm: NewsViewModel? = KoinDIFactory.resolve(NewsViewModel::class)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
       setContent {
           vm?.let {
               NewsListScreen(viewModel = vm)
           }
       }

    }


}
