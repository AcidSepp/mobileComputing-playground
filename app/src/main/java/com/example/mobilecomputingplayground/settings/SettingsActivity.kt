package com.example.mobilecomputingplayground.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mobilecomputingplayground.VeryBasicLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsActivity : ComponentActivity() {

  val settingsViewModel: SettingsViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      VeryBasicLayout {
        SettingsComposable(settingsViewModel)
      }
    }
  }

}

@Composable
fun SettingsComposable(settingsViewModel: SettingsViewModel) {
  val volume by settingsViewModel.volume.collectAsStateWithLifecycle()
  Slider(
    value = volume,
    modifier = Modifier.padding(10.dp),
    onValueChange = { settingsViewModel.changeSliderValue(it) }
  )
}
