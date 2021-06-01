package com.testKotlin.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.testKotlin.BaseActivity
import com.testKotlin.R
import com.testKotlin.databinding.ActivityListsBinding
import com.testKotlin.viewModel.ListsViewModel

class ListActivity : BaseActivity() {
    var binding: ActivityListsBinding? = null
    lateinit var listsViewModel: ListsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListsBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        listsViewModel = ViewModelProvider(this).get(ListsViewModel::class.java)

    }
}