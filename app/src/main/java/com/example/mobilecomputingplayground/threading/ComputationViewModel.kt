package com.example.mobilecomputingplayground.threading

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComputationViewModel : ViewModel() {

  val computation = Computation(this)

  var result by mutableIntStateOf(1337)
  var checked by mutableStateOf(true)

  fun startComputation() {
    viewModelScope.launch {
      withContext(Dispatchers.IO) {
        computation.startComputation()
      }
    }
  }
}
