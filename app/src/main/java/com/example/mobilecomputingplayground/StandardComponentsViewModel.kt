package com.example.mobilecomputingplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class StandardComponentsViewModel : ViewModel() {

  var switchState by mutableStateOf(true)
    private set

  var checkBoxState by mutableStateOf(true)
    private set

  var textFieldState by mutableStateOf("My Input")
    private set

  fun toggleSwitch() {
    switchState = !switchState
  }

  fun toggleCheckBox() {
    checkBoxState = !checkBoxState
  }

  fun enterText(text: String) {
    textFieldState = text
  }

  fun reset() {
    switchState = false
    checkBoxState = false
    textFieldState = "My Input"
  }
}
