package com.cookandroid.ch10_2023_dialog_alarm_01_compatibility

import android.annotation.TargetApi
import android.app.Notification
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    @RequiresApi(Build.VERSION_CODES.S) //애너테이션 1
    @TargetApi(Build.VERSION_CODES.S) //애너테이션 2
    fun noti(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) { //실행 기기의 API 버전이 높을 때만 실행하도록
            val builder: Notification.Builder = Notification.Builder(this, "1")
                .setStyle(
                    Notification.CallStyle.forIncomingCall(
                        caller,
                        declineIntent,
                        answerIntent   // 매개변수 설정이 안되어서 오류는 있는 코드
                    ) //애너테이션 필요함
                )
        }
    }
}