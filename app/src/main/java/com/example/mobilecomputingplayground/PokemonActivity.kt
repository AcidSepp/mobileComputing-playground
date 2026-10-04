package com.example.mobilecomputingplayground

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme
import kotlinx.coroutines.launch

class PokemonActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(
      savedInstanceState,
    )

    val pokeApi = PokeApi()

    lifecycleScope.launch {
      try {
        val requestedPokemon = pokeApi.requestPokemon()
        fillContentWithPokemon(requestedPokemon)
      } catch (e: Exception) {
        Log.e(
          "Testerei",
          "Current Thread: ${Thread.currentThread()}",
          e
        )
      }
    }
  }

  private fun fillContentWithPokemon(message: Pokemon) {
    this@PokemonActivity.setContent {
      MobileComputingPlaygroundTheme {
        Column(
          modifier = Modifier
            .fillMaxWidth(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text("Name: ${message.name}")
          Text("Height: ${message.height}")
          Text("Weight: ${message.weight}")
        }
      }
    }
  }

}
