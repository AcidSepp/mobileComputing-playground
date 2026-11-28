package com.example.mobilecomputingplayground

import kotlin.concurrent.atomics.ExperimentalAtomicApi

class Computation(private val pokemonViewModel: PokemonViewModel) {


  @OptIn(ExperimentalAtomicApi::class)
  suspend fun requestPokemon() {
     
  }

}
