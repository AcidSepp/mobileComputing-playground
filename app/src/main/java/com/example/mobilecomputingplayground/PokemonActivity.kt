package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme

class PokemonActivity : ComponentActivity() {

  private val pokemonViewModel by viewModels<PokemonViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(
      savedInstanceState,
    )

    setContent {
      MobileComputingPlaygroundTheme {
        Column(
          modifier = Modifier.fillMaxWidth(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Button(onClick = {
            pokemonViewModel.changeSelectedPokemon("torchic")
          }) {
            Text("Request Pokemon!")
          }
          Text("Name: ${pokemonViewModel.pokemon.name}")
          Text("Height: ${pokemonViewModel.pokemon.height}")
          Text("Weight: ${pokemonViewModel.pokemon.weight}")
        }
      }
    }
  }

}
