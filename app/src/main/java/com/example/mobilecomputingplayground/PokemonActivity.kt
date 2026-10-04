package com.example.mobilecomputingplayground

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.lifecycle.lifecycleScope
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

class PokemonActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(
      savedInstanceState,
    )

    lifecycleScope.launch(Dispatchers.IO) {
      try {
        val okHttpClient = OkHttpClient()

        val list = listOf(
          "treecko",
          "torchic",
          "mudkip"
        )

        val request = Request.Builder().url(
          "https://pokeapi.co/api/v2/pokemon/${list[0]}"
        ).build()

        val execute = okHttpClient.newCall(request).execute()

        val message = execute.body!!.string()
        println(message)

        this@PokemonActivity.lifecycleScope.launch {
          this@PokemonActivity.setContent {
            MobileComputingPlaygroundTheme {
              Text(message)
            }
          }
        }
      } catch (e: Exception) {
        Log.e(
          "Testerei",
          "Current Thread: ${Thread.currentThread()}",
          e
        )
      }
    }
  }
}
