package com.example.myapplication

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.app.NavUtils
import com.example.myapplication.ui.theme.MyApplicationTheme

class ChildActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {

                var sensorState by remember { mutableStateOf("test") }

                val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
                val sensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)

                val myListener: SensorEventListener = object : SensorEventListener {
                    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                    }

                    override fun onSensorChanged(event: SensorEvent?) {
                        sensorState = if (event == null) {
                            """No Sensor :("""
                        } else {
                            """
                                x: ${event.values[0]}
                                y: ${event.values[1]}
                                z: ${event.values[2]}
                            """.trimIndent()
                        }

                    }
                }

                sensorManager.registerListener(myListener, sensor!!, 1000)


                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopAppBar(
                        title = {
                            Text("Child Activity")
                        },
                        navigationIcon = {
                            Text("Back!", modifier = Modifier.clickable {
                                //stackoverflow.com/a/12276100
                                NavUtils.navigateUpFromSameTask(this@ChildActivity)
                            })
                        },
                        colors = topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.primary,
                        ),
                    )
                }, bottomBar = {
                    BottomAppBar(
                        {

                        })
                }, content = {
                    Text(intent.getStringExtra("myKey") ?: "lel", modifier = Modifier.padding(it))
                })
            }
        }
    }
}

