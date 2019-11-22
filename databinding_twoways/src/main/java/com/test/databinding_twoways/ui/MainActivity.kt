package com.test.databinding_twoways.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.test.databinding_twoways.R
import com.test.databinding_twoways.data.IntervalTimerViewModel
import com.test.databinding_twoways.data.IntervalTimerViewModelFactory
import com.test.databinding_twoways.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val intervalTimerViewModel: IntervalTimerViewModel
            by lazy {
                ViewModelProviders.of(this, IntervalTimerViewModelFactory)
                    .get(IntervalTimerViewModel::class.java)
            }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewmodel = intervalTimerViewModel
        binding.viewmodel = viewmodel
    }
}
