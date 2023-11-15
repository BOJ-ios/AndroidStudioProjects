package com.cookandroid.ch10_2023_statusbar_action_07
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class OneReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        TODO("OneReceiver.onReceive() is not implemented")
        Log.d("yang", "Called OneReceiver")
    }
}