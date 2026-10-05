package com.example.mobilecomputingplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CookieViewModel : ViewModel() {

  var clicks by mutableIntStateOf(0)
    private set


  fun increment() {
    clicks++
  }

}
