package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
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

                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    IchCheckGarNichts("top!")
                }, bottomBar = {
                    BottomAppBar {

                    }
                }, content = {
                    Column(modifier = Modifier.padding(it)) {
                        Text(
                            "Open Tidal", modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    // https://developer.android.com/training/basics/intents/sending
                                    val tidalIntent = Intent(
                                        Intent.ACTION_VIEW, "tidal://track/160954632?play=1".toUri()
                                    )
                                    startActivity(tidalIntent)
                                })
                        Text("Open Sensor Activity", modifier = Modifier.fillMaxWidth().clickable {
                            val myIntent = Intent(this@MainActivity, SensorActivity::class.java)
                            myIntent.putExtra("myKey", "some Value")
                            this@MainActivity.startActivity(myIntent)
                        })
                        Text("Open Blue Activity", modifier = Modifier.fillMaxWidth().clickable {
                            val myIntent = Intent(this@MainActivity, BluetoothActivity::class.java)
                            this@MainActivity.startActivity(myIntent)
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