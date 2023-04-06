package com.azharkova.news.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class NewsActivity : AppCompatActivity() {
    private var listView: RecyclerView? = null


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
