package com.example.mobilecomputingplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PokemonViewModel(val pokeApi: PokeApi = PokeApi()) : ViewModel() {

  var pokemon by mutableStateOf(
    Pokemon(
      "not Loaded",
      "",
      ""
    )
  )

  fun changeSelectedPokemon(name: String) {
    viewModelScope.launch {
      pokemon = pokeApi.requestPokemon()
    }
  }

}
