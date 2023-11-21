package com.cookandroid.ch13_2023_intent_01_basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cookandroid.ch13_2023_intent_01_basic.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("yang","DetailActivity..onCreate..........")
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data1 = intent.getStringExtra("data1") //인텐트의 부가 정보를 가져오는 함수
        val data2 = intent.getIntExtra("data2", 0) //인텐트의 부가 정보를 가져오는 함수

        binding.detailResultView.text = "data1: $data1, data2: $data2"

        binding.detailButton.setOnClickListener {
            intent.putExtra("result","world") //결과로 돌려줄 내용을 추가
            setResult(RESULT_OK, intent) //결과 인텐트를 셋
            finish() //액티비티를 이전으로 돌릴 때 사용하는 함수
        }



    }
}