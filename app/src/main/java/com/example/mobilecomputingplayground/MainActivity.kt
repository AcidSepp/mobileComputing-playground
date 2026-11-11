package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val buttonClickCount = mutableIntStateOf(0)
    setContent {
      ButtonClickDingsi(buttonClickCount)
    }
    Thread({
             Thread.sleep(10_000)
             buttonClickCount.intValue = 42
           }).start()
  }
}

@Composable
fun ButtonClickDingsi(buttonClickCount: MutableIntState) {
  var buttonClickCountRemembered by remember {
    buttonClickCount
  }
  SuperBasicBoringLayout {
    Button(onClick = {
      buttonClickCountRemembered++
    }) {
      Text("Click Count: $buttonClickCountRemembered")
    }
  }
}

