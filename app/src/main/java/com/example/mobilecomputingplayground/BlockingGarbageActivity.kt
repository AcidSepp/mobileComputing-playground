package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class BlockingGarbageActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      VeryBasicLayout {
        BlockingGarbage()
      }
    }
  }
}

@Composable
fun BlockingGarbage() {
  var checked by remember { mutableStateOf(true) }
  var result by remember { mutableIntStateOf(1337) }
  Text("$result")
  Button(onClick = {
    for (i in 0 until Int.MAX_VALUE) {
      for (j in 0 until Int.MAX_VALUE) {
        result *= (i * j)
      }
    }
  }) {
    Text("Do Computation")
  }
  Checkbox(
    checked,
    onCheckedChange = {
      checked = it
    })
}
