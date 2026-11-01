package com.example.mobilecomputingplayground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class VeryBasicViewModel : ViewModel() {
  var box1Checked by mutableStateOf(true)
    private set
  var box2Checked by mutableStateOf(true)
    private set
  var box3Checked by mutableStateOf(true)
    private set

  fun toggleBox1() {
    box1Checked = !box1Checked
  }

  fun toggleBox2() {
    box2Checked = !box2Checked
  }

  fun toggleBox3() {
    box3Checked = !box3Checked
  }

  fun uncheckAllBoxes() {
    box1Checked = false
    box2Checked = false
    box3Checked = false
  }
}
