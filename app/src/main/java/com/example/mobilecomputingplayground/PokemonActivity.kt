package com.example.mobilecomputingplayground

import android.os.Bundle
import android.os.NetworkOnMainThreadException
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme
import okhttp3.OkHttpClient
import okhttp3.Request

class PokemonActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(
      savedInstanceState,
    )

    val okHttpClient = OkHttpClient()

    val list = listOf(
      "treecko",
      "torchic",
      "mudkip"
    )

    val request = Request.Builder().url(
      "https://pokeapi.co/api/v2/pokemon/${list[0]}"
    ).build()

    try {
      val execute = okHttpClient.newCall(request).execute()
      val message = execute.body!!.string()
      println(message)

      setContent {
        MobileComputingPlaygroundTheme {
          Text(message)
        }
      }
    } catch (e: NetworkOnMainThreadException) {
      println("The expected 'NetworkOnMainThreadException' exception!")
      e.printStackTrace()
    }
  }

}
