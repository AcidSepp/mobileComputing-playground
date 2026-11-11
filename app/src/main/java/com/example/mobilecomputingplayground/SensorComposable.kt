package com.example.mobilecomputingplayground

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SensorComposable(sensorViewModel: SensorViewModel) {
  SuperBasicBoringLayout {
    Text("x: ${sensorViewModel.x}")
    Text("y: ${sensorViewModel.y}")
    Text("z: ${sensorViewModel.z}")
    Button(onClick = {
      sensorViewModel.toggleMeasuring()
    }) {
      Text(sensorViewModel.buttonText)
    }
  }
}
