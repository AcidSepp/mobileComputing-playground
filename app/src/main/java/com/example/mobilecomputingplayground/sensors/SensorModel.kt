package com.example.mobilecomputingplayground.sensors

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class SensorModel(
  val sensorViewModel: SensorViewModel,
  val sensorManager: SensorManager,
) {

  val sensor: Sensor? =
    sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY).apply {
      if (this == null) {
        sensorViewModel.sensorUnavailable()
      } else {
        sensorViewModel.sensorAvailable()
      }
    }

  var measurementStarted = false

  val myListener: SensorEventListener = object : SensorEventListener {
    override fun onAccuracyChanged(
      sensor: Sensor?,
      accuracy: Int,
    ) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
      if (event != null) {
        sensorViewModel.updateMeasurements(event.values)
      }
    }
  }

  fun toggleMeasurement() {
    if (!measurementStarted && sensor != null) {
      sensorManager.registerListener(
        myListener,
        sensor,
        5000
      )
      measurementStarted = true
      sensorViewModel.measuringStarted()
    } else if (measurementStarted && sensor != null) {
      sensorManager.unregisterListener(
        myListener,
        sensor
      )
      measurementStarted = false
      sensorViewModel.measuringStopped()
    }
  }
}
