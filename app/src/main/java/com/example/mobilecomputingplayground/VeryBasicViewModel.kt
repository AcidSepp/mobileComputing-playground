package com.example.mobilecomputingplayground

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class VeryBasicViewModel : ViewModel() {

  var box1Checked = mutableStateOf(true)
    private set
  var box2Checked = mutableStateOf(true)
    private set
  var box3Checked = mutableStateOf(true)
    private set
  var box4Checked = mutableStateOf(true)
    private set

}
