package com.azharkova.news.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.azharkova.kmm_news.android.ui.NewsListScreen
import com.azharkova.news.adapter.NewsAdapter
import com.azharkova.test_kmm.*

import com.azharkova.test_kmm.data.NewsList

class NewsActivity : AppCompatActivity() {
    private var listView: RecyclerView? = null


    private var adapter: NewsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // NewsListScreen(viewModel = viewModel)
        }

    }

    override fun onResume() {
        super.onResume()
    }

}
