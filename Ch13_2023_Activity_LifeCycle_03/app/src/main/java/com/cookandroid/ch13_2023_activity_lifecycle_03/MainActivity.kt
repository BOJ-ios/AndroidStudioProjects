package com.cookandroid.ch13_2023_activity_lifecycle_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cookandroid.ch13_2023_activity_lifecycle_03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var count = 0
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("yang","OnCreate()")
        binding.plusCountButton.setOnClickListener {
            count++
            binding.countResultView.text="$count"
            Log.d("yang","Count Button Listener..........")
        } //카운트 증가
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val data1 = savedInstanceState.getString("data1")
        val data2 = savedInstanceState.getInt("count")
        count = data2 //변수 값을 유지하기 위해 사용
        binding.countResultView.text="$data2" //저장 기능이 없으면 값이 사라짐
        // binding.countResultView.text="$data1 - $data2" //저장 기능이 없으면 값이 사라짐
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("yang","onSaveInstanceState..........")
        outState.putString("data1", "hello")
        outState.putInt("count", count)
    }

    override fun onStart() {
        super.onStart()
        Log.d("yang","OnStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("yang","OnResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("yang","OnPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("yang","OnStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("yang","OnRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("yang","OnDestroy()")
    }
}