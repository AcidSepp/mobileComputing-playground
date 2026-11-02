package com.example.mobilecomputingplayground.threading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.mobilecomputingplayground.VeryBasicLayout

class ComputationActivity : ComponentActivity() {

  val computationViewModel by viewModels<ComputationViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      VeryBasicLayout {
        ComputationComposable(computationViewModel)
      }
    }
  }
}

@Composable
fun ComputationComposable(viewModel: ComputationViewModel) {
  Text("${viewModel.result}")
  Button(onClick = {
    viewModel.startComputation()
  }) {
    Text("Do Computation")
  }
  Checkbox(
    viewModel.checked,
    onCheckedChange = {
      viewModel.checked = it
    })
}
