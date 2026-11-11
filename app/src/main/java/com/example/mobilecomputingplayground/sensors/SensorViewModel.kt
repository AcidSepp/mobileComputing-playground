package com.example.mobilecomputingplayground.sensors

import android.app.Application
import android.content.Context.SENSOR_SERVICE
import android.hardware.SensorManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class SensorViewModel(sensorManager: SensorManager) : ViewModel() {

  var buttonText by mutableStateOf("Start Measuring!")
    private set

  var x: Float by mutableFloatStateOf(0f)
    private set

  var y: Float by mutableFloatStateOf(0f)
    private set
  var z: Float by mutableFloatStateOf(0f)
    private set

  var buttonGreyedOut: Boolean by mutableStateOf(true)
    private set

  var showMeasurements: Boolean by mutableStateOf(false)
    private set

  var sensorModel = SensorModel(
    this,
    sensorManager
  )

  fun toggleMeasurement() {
    sensorModel.toggleMeasurement()
  }

  fun updateMeasurements(values: FloatArray) {
    this.x = values[0]
    this.y = values[1]
    this.z = values[2]
    showMeasurements = true
  }

  fun measuringStarted() {
    buttonText = "Stop Measuring!"
  }

  fun measuringStopped() {
    buttonText = "Start Measuring!"
  }

  fun sensorUnavailable() {
    buttonGreyedOut = true
  }

  fun sensorAvailable() {
    buttonGreyedOut = false
  }

  companion object {
    val factory: ViewModelProvider.Factory = viewModelFactory {
      initializer {
        val app =
          this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as Application
        val sensorManager =
          app.getSystemService(SENSOR_SERVICE) as SensorManager
        SensorViewModel(sensorManager)
      }
    }
  }

}
