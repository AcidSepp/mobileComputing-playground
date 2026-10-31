package com.example.mobilecomputingplayground

import android.app.ComponentCaller
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material3.Text

class GarbageActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(
      savedInstanceState,
    )

    setContent {
      Text("Garbage Activity")
    }

  }

  @RequiresApi(Build.VERSION_CODES.TIRAMISU)
  override fun onNewIntent(
    intent:
    Intent,
    caller: ComponentCaller,
  ) {
    super.onNewIntent(
      intent,
      caller
    )
    val uri =
      intent.getParcelableExtra(
        Intent.EXTRA_STREAM,
        Uri::class.java
      )

    setContent {
      Text(uri.toString())
    }
  }

}
