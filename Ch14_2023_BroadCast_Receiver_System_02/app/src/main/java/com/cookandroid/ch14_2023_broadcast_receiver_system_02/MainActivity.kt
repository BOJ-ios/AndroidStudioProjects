package com.cookandroid.ch14_2023_broadcast_receiver_system_02

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    lateinit var receiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = object : BroadcastReceiver(){ //브로드캐스트 리시버 객체 작성
            override fun onReceive(context: Context?, intent: Intent?) { //메소드 구현
                when(intent?.action){
                    Intent.ACTION_SCREEN_ON -> Log.d("Yang", "screen on")
                    Intent.ACTION_SCREEN_OFF -> Log.d("Yang", "screen off")
                    Intent.ACTION_BATTERY_OKAY -> Log.d("Yang", "ACTION_BATTERY_OKAY...")
                    Intent.ACTION_BATTERY_LOW -> Log.d("Yang", "ACTION_BATTERY_LOW...")
                    Intent.ACTION_BATTERY_CHANGED -> Log.d("Yang", "ACTION_BATTERY_CHANGED...")
                    Intent.ACTION_POWER_CONNECTED -> Log.d("Yang", "ACTION_POWER_CONNECTED...")
                    Intent.ACTION_POWER_DISCONNECTED -> Log.d("Yang", "ACTION_POWER_DISCONNECTED...")
                }
            }
        }

        //인텐트 필터 설정, 액션 문자열을 등록하는 과정, addAction() 함수 이용
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_ON)
            addAction(Intent.ACTION_SCREEN_OFF)
            addAction(Intent.ACTION_BATTERY_OKAY)
            addAction(Intent.ACTION_BATTERY_CHANGED)
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        registerReceiver(receiver, filter) //화면 켜기, 끄기 등은 동적 등록을 해야 함


        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus = registerReceiver(null, intentFilter) //베터리 변화에 대한 리시버 동적 등록록

       val status = batteryStatus!!.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
        if (status == BatteryManager.BATTERY_STATUS_CHARGING) {
            // 전원이 공급되고 있다면
            val chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
            when (chargePlug) {
                BatteryManager.BATTERY_PLUGGED_USB -> Log.d("Yang", "usb charge")
                BatteryManager.BATTERY_PLUGGED_AC -> Log.d("Yang", "ac charge")
            }
        } else {
            // 전원이 공급되고 있지 않다면
            Log.d("Yang", "not charging")
        }

        val level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        val batteryPct = level / scale.toFloat() * 100
        Log.d("Yang", "batteryPct : $batteryPct")
    }
}