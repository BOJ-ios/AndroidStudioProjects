package com.cookandroid.ch10_2023_notification_vibration_05

import android.content.Context
import android.media.RingtoneManager
import android.net.Uri
import android.os.*
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cookandroid.ch10_2023_notification_vibration_05.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val notification: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION) //소리 식별자 획득, Uri 객체
            val ringtone = RingtoneManager.getRingtone(applicationContext, notification) //ringtone 객체 획득
            ringtone.play() //소리 재생
        }
        binding.button2.setOnClickListener {
            val vibrator  = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                Log.d("yang", "진동 발생")
                val vibratorManager =  this.getSystemService(VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator;
            } else {
                getSystemService(VIBRATOR_SERVICE) as Vibrator
            }
//         var vibrator =  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                vibrator.vibrate(
//                    VibrationEffect.createOneShot(500,
//                    VibrationEffect.DEFAULT_AMPLITUDE))
//            } else {
//                vibrator.vibrate(500)
//            }


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(
                    VibrationEffect.createWaveform(longArrayOf(500, 1000, 500, 2000),
                        intArrayOf(0, 50, 0, 200), -1))
            } else {
                vibrator.vibrate(longArrayOf(500, 1000, 500, 2000), -1)
            }
        }
    }
}