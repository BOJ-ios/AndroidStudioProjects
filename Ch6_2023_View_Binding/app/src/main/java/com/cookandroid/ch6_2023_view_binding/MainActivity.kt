package com.cookandroid.ch6_2023_view_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cookandroid.ch6_2023_view_binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.visibleBtn.setOnClickListener {
            binding.targetView.visibility = View.VISIBLE
        }
        binding.invisibleBtn.setOnClickListener {
            binding.targetView.visibility = View.INVISIBLE
        }

        binding.goneBtn.setOnClickListener {
            binding.targetView.visibility = View.GONE
        }
    }
}