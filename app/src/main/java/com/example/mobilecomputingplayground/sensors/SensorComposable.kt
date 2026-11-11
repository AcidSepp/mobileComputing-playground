package com.example.mobilecomputingplayground.sensors

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.mobilecomputingplayground.VeryBasicLayout

@Composable
fun SensorLayout(
  sensorViewModel: SensorViewModel,
) {
  VeryBasicLayout {
    Button(
      onClick = {
        sensorViewModel.toggleMeasurement()
      },
      enabled = !sensorViewModel.buttonGreyedOut
    ) {
      Text(sensorViewModel.buttonText)
    }

    if (sensorViewModel.showMeasurements) {
      Text("x: ${sensorViewModel.x}")
      Text("y: ${sensorViewModel.y}")
      Text("z: ${sensorViewModel.z}")
    } else {
      Text("No measurements available!")
    }
  }
}
