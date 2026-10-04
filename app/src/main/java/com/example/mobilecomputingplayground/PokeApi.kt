package com.example.mobilecomputingplayground

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

data class Pokemon(val name: String, val height: String, val weight: String)

class PokeApi {

  suspend fun requestPokemon(): Pokemon {
    return withContext(Dispatchers.IO) {

      val list = listOf(
        "treecko",
        "torchic",
        "mudkip"
      )

      val request = Request.Builder().url(
        "https://pokeapi.co/api/v2/pokemon/${list[0]}"
      ).build()

      val execute = CLIENT.newCall(request).execute()

      val result = execute.body!!.string()
      return@withContext GSON.fromJson(
        result,
        Pokemon::class.java
      )
    }
  }

  companion object {
    val GSON by lazy {
      Gson()
    }
    val CLIENT by lazy {
      OkHttpClient()
    }
  }

}
