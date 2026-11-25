package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {

  val viewModel: ComputationViewModel by viewModels<ComputationViewModel>()

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
fun BlockingGarbage(computationViewModel: ComputationViewModel) {
  Text("${computationViewModel.result}")
  Button(onClick = {
    computationViewModel.startComputation()
  }) {
    Text("Do Computation")
  }
  Checkbox(
    computationViewModel.checked,
    onCheckedChange = {
      computationViewModel.checked = it
    })
}
