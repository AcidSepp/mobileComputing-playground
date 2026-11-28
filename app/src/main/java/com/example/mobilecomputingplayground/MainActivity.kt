package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {

  val viewModel: PokemonViewModel by viewModels<PokemonViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SuperBasicBoringLayout() {
        BlockingGarbage(viewModel)
      }
    }
  }
}

@Composable
fun BlockingGarbage(viewModel: PokemonViewModel) {
  Text("${viewModel.name}")
  Text("${viewModel.size}")
  Text("${viewModel.weight}")
}
