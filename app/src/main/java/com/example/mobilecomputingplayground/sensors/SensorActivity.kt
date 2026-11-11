package com.example.mobilecomputingplayground.sensors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme

class SensorActivity : ComponentActivity() {

  private val sensorViewModel: SensorViewModel by viewModels {
    SensorViewModel.factory
  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileComputingPlaygroundTheme {
              SensorLayout(sensorViewModel)
            }
        }
    }

}
