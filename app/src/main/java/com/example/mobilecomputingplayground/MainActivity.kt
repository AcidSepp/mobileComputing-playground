package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
  var clicksCount = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Button(onClick = {
        onButtonPressed()
      }) {
        Text("Clicks count: $clicksCount")
      }
    }
  }

  fun onButtonPressed() {
    clicksCount++
    setContent {
      Button(onClick = {
        onButtonPressed()
      }) {
        Text("Clicks count: $clicksCount")
      }
    }
  }
}

