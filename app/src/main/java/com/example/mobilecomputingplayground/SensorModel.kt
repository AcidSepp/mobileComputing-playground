package com.example.mobilecomputingplayground

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class SensorModel(
  val sensorViewModel: SensorViewModel,
  val sensorManager: SensorManager,
) {

  val sensor: Sensor? =
    sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)

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

  fun startMeasurement() {
    sensorManager.registerListener(
      myListener,
      sensor,
      1_000_000
    )
  }

  fun stopMeasurement() {
    sensorManager.unregisterListener(myListener)
  }

}
