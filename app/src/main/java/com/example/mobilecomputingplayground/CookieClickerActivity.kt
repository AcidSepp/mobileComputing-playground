package com.example.mobilecomputingplayground

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme

class CookieClickerActivity : ComponentActivity() {

  val clicks by viewModels<CookieViewModel>()

  @SuppressLint("UnrememberedMutableState")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MobileComputingPlaygroundTheme {
        SetCookeClickerActivityContent(clicks)
      }
    }
  }

}

@Composable
fun SetCookeClickerActivityContent(clickViewModel: CookieViewModel) {
  Scaffold(modifier = Modifier.fillMaxSize()) {
    Column(modifier = Modifier.fillMaxSize()) {
      Row {
        Image(
          painterResource(R.drawable.haw_landshut),
          "HAW Landshut Logo",
          modifier = Modifier.clickable {
            clickViewModel.increment()
          })
      }
      Row {
        Text(
          "Clicks: ${clickViewModel.clicks}",
          textAlign = TextAlign.Center,
          fontSize = 30.sp,
          modifier = Modifier
            .padding(it)
            .fillMaxWidth()
        )
      }
    }
  }
}
