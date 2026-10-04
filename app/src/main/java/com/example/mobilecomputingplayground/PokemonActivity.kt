package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

          var expandDropDownMenu by remember { mutableStateOf(true) }
          var selectedPokemon by remember { mutableStateOf("Treecko") }


          Button(onClick = {
            pokemonViewModel.changeSelectedPokemon(selectedPokemon)
          }) {
            Text("Request $selectedPokemon")
          }

          Text("Name: ${pokemonViewModel.pokemon.name}")
          Text("Height: ${pokemonViewModel.pokemon.height}")
          Text("Weight: ${pokemonViewModel.pokemon.weight}")

          Button(onClick = {
            expandDropDownMenu = true
          }) {
            Text("Change Selected Pokemon")
          }

          DropdownMenu(
            expanded = expandDropDownMenu,
            onDismissRequest = { expandDropDownMenu = false }
          ) {
            DropdownMenuItem(
              text = { Text("Treecko") },
              onClick = { selectedPokemon = "Treecko" }
            )
            DropdownMenuItem(
              text = { Text("Torchic") },
              onClick = { selectedPokemon = "Torchic" }
            )
            DropdownMenuItem(
              text = { Text("Mudkip") },
              onClick = { selectedPokemon = "Mudkip" }
            )
          }
        }
      }
    }
  }

}
