package com.azharkova.kmm_news.android.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

import com.azharkova.test_kmm.data.NewsList
import com.azharkova.test_kmm.viewmodels.NewsViewModel
import com.azharkova.test_kmm.viewmodels.NewsView

class NewsActivity : AppCompatActivity(), NewsView {
    private val viewModel: NewsViewModel by lazy {
         NewsViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContent {
           NewsListScreen(viewModel = viewModel)
       }
    }

    override fun setupData(data: NewsList) {}

    override fun onResume() {
        super.onResume()
        viewModel.loadNews()
    }
}
