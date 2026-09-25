package com.example.mobilecomputingplayground

import android.app.ComponentCaller
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme

class ImageActivity : ComponentActivity() {

    val viewModel = ImageViewModel()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onNewIntent(intent: Intent, caller: ComponentCaller) {
        super.onNewIntent(
            intent,
            caller
        )
        val uri = intent.getParcelableExtra(
            Intent.EXTRA_STREAM,
            Uri::class.java
        )
        viewModel.updateUri(uri)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val uri = intent.getParcelableExtra(
            Intent.EXTRA_STREAM,
            Uri::class.java
        )
        viewModel.updateUri(uri)

        setContent {
            MobileComputingPlaygroundTheme {
                AsyncImage(
                    viewModel.uri,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

}