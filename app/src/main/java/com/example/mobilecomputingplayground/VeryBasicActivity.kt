package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class VeryBasicActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val clickCount = mutableIntStateOf(0)
    setContent {
      Column {
        ClicksCount(clickCount)
      }
    }

    Thread({
             Thread.sleep(5000)

             clickCount.intValue = 30

           }).start()
  }
}

@Composable
fun ClicksCount(clickCount: MutableIntState) {
  var remembered by remember {
    clickCount
  }

  for (i in 0 until remembered) {
    Text(i.toString())
  }

  Button(onClick = {
    remembered++
  }) {
    Text("Click Me!")
  }
}
