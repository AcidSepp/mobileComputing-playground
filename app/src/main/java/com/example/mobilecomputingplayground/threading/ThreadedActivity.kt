package com.example.mobilecomputingplayground.threading

import android.os.Bundle
import android.util.Log
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
import com.example.mobilecomputingplayground.VeryBasicLayout

class ThreadedActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      VeryBasicLayout {
        Threaded()
      }
    }
  }
}

@Composable
fun Threaded() {
  var checked by remember { mutableStateOf(true) }
  var result by remember { mutableIntStateOf(1337) }

  Text("$result")
  Button(onClick = {
    val thread = Thread(
      {
        for (i in 1 until Int.MAX_VALUE) {
          for (j in 1 until Int.MAX_VALUE) {
            Log.i(
              "test",
              "Computing!"
            )
            result = i * j
          }
        }
      })
    thread.start()
  }) {
    Text("Do Computation")
  }
  Checkbox(
    checked,
    onCheckedChange = {
      checked = it
    })
}
