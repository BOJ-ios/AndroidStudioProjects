package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        callbackMethod(paramFunc= {it:String ->
            Log.d("myTag", it)
        })
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun callbackMethod( paramFunc : (String)-> Unit){
        Log.d("myTag","MainActivity called this func")
        Handler(Looper.getMainLooper()).postDelayed({
            paramFunc("ㅋㅋㅋㅋㅋ")
        }, 1000L)
    }
}