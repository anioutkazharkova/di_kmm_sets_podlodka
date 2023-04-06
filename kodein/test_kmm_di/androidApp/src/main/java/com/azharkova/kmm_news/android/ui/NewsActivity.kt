package com.azharkova.news.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azharkova.kmm_news.android.R
import com.azharkova.kmm_news.android.ui.NewsListScreen
import com.azharkova.news.adapter.NewsAdapter
import com.azharkova.test_kmm.*

import com.azharkova.test_kmm.data.NewsList
import com.azharkova.test_kmm.presenter.NewsView
import com.azharkova.test_kmm.presenter.NewsViewModel

class NewsActivity : AppCompatActivity(), NewsView {

    val viewModel: NewsViewModel?  = VMFactory.createVM(this) as? NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel?.let {
                NewsListScreen(viewModel)
            }
        }

    }
}
