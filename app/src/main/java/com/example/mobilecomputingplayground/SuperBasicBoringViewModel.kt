package com.example.mobilecomputingplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SuperBasicBoringViewModel : ViewModel() {

  var switch3Enabled by mutableStateOf(true)
  var switch2Enabled by mutableStateOf(true)
  var switch1Enabled by mutableStateOf(true)

  fun switch1Toggled() {
    switch1Enabled = !switch1Enabled
  }

  fun switch2Toggled() {
    switch2Enabled = !switch2Enabled
  }

  fun switch3Toggled() {
    switch3Enabled = !switch3Enabled
  }

  fun uncheckAll() {
    switch1Enabled = false
    switch2Enabled = false
    switch3Enabled = false
  }
}
