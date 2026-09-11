package com.example.myapplication

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {

                var sensorState by remember { mutableStateOf("test") }

                val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
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
                    IchCheckGarNichts("top!")
                }, bottomBar = {
                    BottomAppBar {
                        Text("Go to next activity", modifier = Modifier.clickable {
                            val myIntent = Intent(this@MainActivity, ChildActivity::class.java)
                            myIntent.putExtra("myKey", "some Value")
                            this@MainActivity.startActivity(myIntent)
                        })
                    }
                }, content = {
                    Column(modifier = Modifier.padding(it)) {
                        Text(sensorState, modifier = Modifier.fillMaxSize())
                        Text(
                            "Open Tidal", modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    // https://developer.android.com/training/basics/intents/sending
                                    val tidalIntent = Intent(
                                        Intent.ACTION_VIEW, "tidal://track/160954632?play=1".toUri()
                                    )
                                    startActivity(tidalIntent)
                                })
                    }
                })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IchCheckGarNichts(name: String) {
    TopAppBar(
        title = {
            Greeting(
                name = name
            )
        },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
    )
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}