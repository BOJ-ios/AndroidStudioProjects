package com.cookandroid.ch10_2023_custom_dialog_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.cookandroid.ch10_2023_custom_dialog_04.databinding.ActivityMainBinding
import com.cookandroid.ch10_2023_custom_dialog_04.databinding.DialogInputBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val dialogBinding = DialogInputBinding.inflate(layoutInflater) 
            AlertDialog.Builder(this).run {
                setTitle("Input")
                setView(dialogBinding.root)
                setPositiveButton("닫기", null)
                show()
            }
        }
    }
}