package com.cookandroid.ch14_2023_broadcast_receiver_basic_01

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cookandroid.ch14_2023_broadcast_receiver_basic_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val intent = Intent(this, MyReceiver::class.java) //정적 등록 형태
            sendBroadcast(intent) //브로드캐스트 리시버를 실행하는 인텐트는 sendBroadCast() 함수로 시스템에 전달
        }

        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.d("yang","registerReceiver... onReceive..........")
            }
        }
        val filter = IntentFilter("ACTION_RECEIVER")
        registerReceiver(receiver, filter) //브로드캐스트 리시버 등록 (동적 등록 형태)

        binding.button2.setOnClickListener {
            val intent = Intent("ACTION_RECEIVER")
            sendBroadcast(intent)
        }
    }
}
/*
class MyReceiver: BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        TODO("Not yet implemented")
        Log.d("yang","in MyReceiver Class... onReceive..........")
    }
}
*/
