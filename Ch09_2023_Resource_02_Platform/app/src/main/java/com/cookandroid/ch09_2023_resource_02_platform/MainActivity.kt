package com.cookandroid.ch09_2023_resource_02_platform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.cookandroid.ch09_2023_resource_02_platform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.imageView.setImageDrawable(ResourcesCompat.getDrawable(resources, android.R.drawable.alert_dark_frame, null))
        binding.textView.text = getString(android.R.string.emptyPhoneNumber)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
    }
}