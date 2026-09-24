package com.example.myapplication

import android.Manifest
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
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
import androidx.core.app.ActivityCompat
import androidx.core.app.NavUtils
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme

class BluetoothActivity : ComponentActivity() {

//    lateinit var scanCallback: ScanCallback

    @RequiresApi(Build.VERSION_CODES.S)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val bluetoothDevices = mutableSetOf<String>()
        val bluetoothDevicesMutableState =
            mutableStateOf(bluetoothDevices.joinToString())

        setContent {
            MobileComputingPlaygroundTheme {

                var bluetoothDevicesStringState by remember { bluetoothDevicesMutableState }

                val systemService = getSystemService(
                    BluetoothManager::class.java
                )!!
                val bluetoothAdapter = systemService.adapter!!

                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.BLUETOOTH_SCAN
                    ) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@BluetoothActivity,
                        arrayOf(
                            Manifest.permission.BLUETOOTH_SCAN,
                            Manifest.permission.BLUETOOTH_CONNECT
                        ),
                        123
                    )
                }

//                scanCallback = object : ScanCallback() {
//                    @RequiresApi(Build.VERSION_CODES.S)
//                    override fun onScanResult(callbackType: Int, result: ScanResult?) {
//                        result?.let {
//                            if (ActivityCompat.checkSelfPermission(
//                                    this@BleActivity, Manifest.permission.BLUETOOTH_CONNECT
//                                ) != PackageManager.PERMISSION_GRANTED
//                            ) {
//                                // TODO: Consider calling
//                                //    ActivityCompat#requestPermissions
//                                // here to request the missing permissions, and then overriding
//                                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                                //                                          int[] grantResults)
//                                // to handle the case where the user grants the permission. See the documentation
//                                // for ActivityCompat#requestPermissions for more details.
//
//
//                                ActivityCompat.requestPermissions(
//                                    this@BleActivity,
//                                    arrayOf(Manifest.permission.BLUETOOTH_CONNECT),
//                                    123
//                                )
//
//                                bleState = "Not permitted"
//                                return
//                            }
//                            bleState = it.device.name
//                        }
//                    }
//                }

                val receiver = object : BroadcastReceiver() {

                    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
                    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
                    override fun onReceive(
                        context: Context,
                        intent: Intent,
                    ) {
                        val action: String = intent.action!!
                        when (action) {
                            BluetoothDevice.ACTION_FOUND -> {
                                // Discovery has found a device. Get the BluetoothDevice
                                // object and its info from the Intent.
                                val device: BluetoothDevice =
                                    intent.getParcelableExtra(
                                        BluetoothDevice.EXTRA_DEVICE,
                                        BluetoothDevice::class.java
                                    )!!

                                bluetoothDevices += "${device.name} ${device.address}\n"
                                bluetoothDevicesStringState =
                                    bluetoothDevices.joinToString()
                            }
                        }
                    }
                }

                val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
                registerReceiver(
                    receiver,
                    filter
                )
                bluetoothAdapter.startDiscovery()
                bluetoothDevicesStringState = "Scan started!"

                BluetoothLayout(
                    {
                        //stackoverflow.com/a/12276100
                        NavUtils.navigateUpFromSameTask(this@BluetoothActivity)
                    },
                )

            }
        }
    }

    @RequiresPermission(Manifest.permission.BLUETOOTH_SCAN)
    override fun onDestroy() {
        super.onDestroy()
//        val systemService = getSystemService(
//            BluetoothManager::class.java
//        )!!
//        val bluetoothAdapter = systemService.adapter!!
//        bluetoothAdapter.bluetoothLeScanner?.stopScan(scanCallback)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BluetoothLayout(
    onNavigationItemClicked: () -> Unit = {},
    contentMutableState: MutableState<String> = mutableStateOf("No Devices found"),
) {
    Scaffold(
        modifier = Modifier.fillMaxSize().padding(),
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

