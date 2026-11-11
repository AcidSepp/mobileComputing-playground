package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class SensorActivity : ComponentActivity() {

  private val sensorViewModel: SensorViewModel by viewModels {
    SensorViewModel.factory
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SensorComposable(sensorViewModel)
    }
  }
}
