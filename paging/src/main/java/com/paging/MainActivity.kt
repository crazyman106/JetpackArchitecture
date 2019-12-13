package com.paging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.AsyncPagedListDiffer
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.recyclerview.widget.AsyncListUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
