package com.example.mobilecomputingplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PokemonViewModel() : ViewModel() {

  val weight by mutableStateOf("")
  val size by mutableStateOf("")
  val name by mutableStateOf("")

  fun requestPokemon() {

  }

}
