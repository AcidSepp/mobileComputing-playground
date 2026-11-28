package com.example.mobilecomputingplayground.cookies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mobilecomputingplayground.R
import com.example.mobilecomputingplayground.VeryBasicLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CookieClickerActivity : ComponentActivity() {

  val cookieClickerViewModel by viewModels<CookieViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      VeryBasicLayout {
        CookieClickerComponent(cookieClickerViewModel)
      }
    }
  }
}

@Composable
fun CookieClickerComponent(clickViewModel: CookieViewModel) {
  val clicks by clickViewModel.clicks.collectAsStateWithLifecycle()
  val user by clickViewModel.userId.collectAsStateWithLifecycle()

  Row {
    Button(onClick = {
      clickViewModel.changeUser(0)
    }) {
      Text("User 0")
    }
    Button(onClick = {
      clickViewModel.changeUser(1)
    }) {
      Text("User 1")
    }
    Button(onClick = {
      clickViewModel.changeUser(2)
    }) {
      Text("User 2")
    }
  }

  Image(
    painterResource(R.drawable.haw_landshut),
    "HAW Landshut Logo",
    modifier = Modifier.clickable {
      clickViewModel.increment()
    })
  Text(
    "Clicks: $clicks",
  )
  Text(
    "User: $user",
  )
}
