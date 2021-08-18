package com.catalin.viewmodel_state

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.catalin.viewmodel_state.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: SaveStateViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.button.setOnClickListener { viewModel.increment() }
        viewModel.counterLiveData.observe(this, Observer {
            binding.textView.text = it.toString()
        })
    }
}