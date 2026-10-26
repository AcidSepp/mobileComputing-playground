package com.example.mobilecomputingplayground

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiver : BroadcastReceiver() {
  override fun onReceive(context: Context?, intent: Intent?) {
    if (intent?.type == Intent.ACTION_AIRPLANE_MODE_CHANGED) {

    }
  }
}
