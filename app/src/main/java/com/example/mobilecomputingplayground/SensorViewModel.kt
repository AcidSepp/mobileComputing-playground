package com.example.mobilecomputingplayground

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

  var x by mutableFloatStateOf(0f)
    private set
  var y by mutableFloatStateOf(0f)
    private set
  var z by mutableFloatStateOf(0f)
    private set
  var buttonText by mutableStateOf("Start Measure")
    private set

  private var isMeasuring = false
  private var sensorModel = SensorModel(
    this,
    sensorManager
  )

  fun toggleMeasuring() {
    if (!isMeasuring) {
      sensorModel.startMeasurement()
      isMeasuring = true
      buttonText = "Stop Measure!"
    } else {
      sensorModel.stopMeasurement()
      isMeasuring = false
      buttonText = "Start Measure!"
    }
  }

  fun updateMeasurements(values: FloatArray) {
    x = values[0]
    y = values[1]
    z = values[2]
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
