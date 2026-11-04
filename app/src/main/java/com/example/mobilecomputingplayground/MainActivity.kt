package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(
      savedInstanceState,
    )

    setContent {
      MobileComputingPlaygroundTheme {
        Greeting(
          "Servus",
          "World"
        )
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Greeting(
  greeting: String = "Ich änder hier was",
  subject: String = "World",
) {
  SuperBasicBoringLayout {
    Text(
      "$greeting, $subject!",
      color = Color.Red,
      modifier = Modifier.alpha(0.5f)
    )
    Text("two")
    Text("three")
  }
}
