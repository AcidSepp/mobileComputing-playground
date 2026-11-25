package com.example.mobilecomputingplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComputationViewModel() : ViewModel() {

  private val computation: Computation = Computation(this)

  fun startComputation() {
    print("hallo")
    viewModelScope.launch {
      withContext(Dispatchers.IO) {
        computation.startComputation()
      }
    }
  }

  var checked by mutableStateOf(true)
  var result by mutableIntStateOf(1337)
}
