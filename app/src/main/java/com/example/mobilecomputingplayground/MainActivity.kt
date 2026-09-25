package com.example.mobilecomputingplayground

import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.core.net.toUri
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme
import com.example.myapplication.BluetoothActivity
import com.example.myapplication.ChildActivity
import com.example.myapplication.SensorActivity

class MainActivity : ComponentActivity() {

    // In the parent Activity, declared as a property (not inside onClick)
    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        topText = "Child Activity result " + result.resultCode.toString()
        Log.i(
            "testerei",
            result.data.toString()
        )
    }

    private var topText by mutableStateOf("Top")


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val am = getSystemService(ActivityManager::class.java)
        am.appTasks.forEach { task ->
            val info = task.taskInfo
            Log.d(
                "BackStack",
                "base=${info!!.baseActivity?.className} " + "top=${info.topActivity?.className} count=${info.numActivities}"
            )
        }

        setContent {
            MobileComputingPlaygroundTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(topText)
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                        )
                    },
                    bottomBar = {
                        BottomAppBar {

                        }
                    },
                    content = {
                        Column(
                            modifier = Modifier
                                .padding(it)
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button({
                                       // https://developer.android.com/training/basics/intents/sending
                                       Intent(
                                           Intent.ACTION_VIEW,
                                           "https://haw-landshut.de".toUri()
                                       ).also {
                                           startActivity(it)
                                       }
                                   }) {
                                Text("Open haw-landshut.de")
                            }
                            Button({
                                       val myIntent = Intent(
                                           this@MainActivity,
                                           SensorActivity::class.java
                                       )
                                       myIntent.putExtra(
                                           "myKey",
                                           "some Value"
                                       )
                                       this@MainActivity.startActivity(myIntent)
                                   }) {
                                Text("Open Sensor Activity")
                            }

                            Button({
                                       val myIntent = Intent(
                                           this@MainActivity,
                                           BluetoothActivity::class.java
                                       )
                                       this@MainActivity.startActivity(myIntent)
                                   }) {
                                Text("Open Blue Activity")
                            }

                            Button({
                                       val myIntent = Intent()
                                       myIntent.setClass(
                                           this@MainActivity,
                                           ChildActivity::class.java
                                       )
                                       launcher.launch(myIntent)
                                   }) {
                                Text("Open Child Activity")
                            }

                            Button({
                                       val myIntent = Intent(
                                           this@MainActivity,
                                           MainActivity::class.java
                                       )
                                       this@MainActivity.startActivity(myIntent)
                                   }) {
                                Text("Open Main Activity")
                            }

                            Button(
                                {
                                    Intent(Intent.ACTION_MAIN).also {
                                        it.`package` =
                                            "com.google.android.youtube"
                                        startActivity(it)
                                    }
                                }) {
                                Text("Open Youtube")
                            }

                            Image(
                                painterResource(R.drawable.haw_landshut),
                                contentDescription = "The Logo of the University for applied science, Landshut"
                            )


                        }
                    })
            }
        }
    }
}


