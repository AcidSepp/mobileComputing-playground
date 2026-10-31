package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme

class VeryBasicActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MobileComputingPlaygroundTheme(darkTheme = true) {
        Greeting(
          "Hello",
          "World"
        )
      }
    }
  }
}

@Composable
@Preview
fun Greeting(
  greeting: String = "Hello",
  subject: String = "World",
) {
  Text("$greeting, $subject!")
}
