@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.mobilecomputingplayground.settings

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(val settingsModel: SettingsModel) :
  ViewModel() {

  val volume: StateFlow<Float> = settingsModel.volume.stateIn(
    viewModelScope,
    SharingStarted.WhileSubscribed(5_000),
    1.0f
  )


  fun changeSliderValue(it: Float) {
    viewModelScope.launch {
      settingsModel.changeSliderValue(it)
    }
  }

}
