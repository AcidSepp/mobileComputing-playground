package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(
      savedInstanceState,
    )

    val stringExtra = intent.getStringExtra("myKey")

    setContent {
      Text("Main Activity $stringExtra")
    }

    setResult(1337)
    finish()
  }
}
