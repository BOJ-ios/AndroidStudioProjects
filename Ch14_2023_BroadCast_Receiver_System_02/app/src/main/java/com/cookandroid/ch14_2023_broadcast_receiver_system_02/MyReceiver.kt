package com.cookandroid.ch14_2023_broadcast_receiver_system_02

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("Yang","In MyReceiver class... onReceive..........")
    }
}