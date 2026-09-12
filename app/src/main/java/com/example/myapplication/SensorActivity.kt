package com.example.myapplication

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NavUtils
import com.example.myapplication.ui.theme.MyApplicationTheme

class SensorActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val sensorMutableState = mutableStateOf("test")

        setContent {
            MyApplicationTheme {

                var sensorState by remember { sensorMutableState }

                val sensorManager =
                    getSystemService(SENSOR_SERVICE) as SensorManager
                val sensor: Sensor? =
                    sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)

                val myListener: SensorEventListener =
                    object : SensorEventListener {
                        override fun onAccuracyChanged(
                            sensor: Sensor?,
                            accuracy: Int,
                        ) {
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

                sensorManager.registerListener(
                    myListener,
                    sensor!!,
                    1000
                )


                SensorLayout(
                    {
                        //stackoverflow.com/a/12276100
                        NavUtils.navigateUpFromSameTask(this@SensorActivity)
                    },
                    sensorMutableState
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun SensorLayout(
        onNavigationItemClicked: () -> Unit = {},
        contentMutableState: MutableState<String> = mutableStateOf("No Devices found"),
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            BluetoothActivity::class.simpleName.toString(),
                            textAlign = TextAlign.Right
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onNavigationItemClicked) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                )
            },
            content = {
                val contentString by remember { contentMutableState }
                Text(
                    contentString,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(it)
                        .padding(20.dp)
                        .fillMaxWidth()
                )
            })
    }
}
