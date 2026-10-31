package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme

class VeryBasicActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MobileComputingPlaygroundTheme {
        ScaffoldExample()
      }
    }
  }
}

@Composable
fun NoLayoutsExample() {
  Text(
    "One",
  )
  Text(
    "Two",
  )
  Text(
    "Three",
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = {
      TopAppBar(
        title = {
          Text("Top")
        })
    },
    content = {
      ColumnExample()
      it
    },
    bottomBar = {
      BottomAppBar {
        Text("Bottom")
      }
    },
  )
}

@Composable
fun ColumnExample() {
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Center,
    horizontalAlignment = CenterHorizontally
  ) {
    MoreComposables()
  }
}

@Composable
fun MoreComposables() {
  Button(onClick = {}) {
    Text(
      "My First Button :)",
    )
  }
  Switch(
    checked = true,
    onCheckedChange = {})
  Checkbox(
    false,
    onCheckedChange = {})
  OutlinedTextField(
    "My TexField :)!",
    onValueChange = {})
  Image(
    painterResource(R.drawable.haw_landshut),
    contentDescription = "HAW Landshut Logo"
  )
}

