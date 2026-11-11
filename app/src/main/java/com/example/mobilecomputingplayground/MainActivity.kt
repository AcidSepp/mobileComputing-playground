package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {

  val viewModel: SuperBasicBoringViewModel by viewModels<SuperBasicBoringViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SwitchClickDingsi(viewModel)
    }
  }
}

@Composable
fun SwitchClickDingsi(superBasicBoringViewModel: SuperBasicBoringViewModel = SuperBasicBoringViewModel()) {
  SuperBasicBoringLayout {
    Switch(
      superBasicBoringViewModel.switch1Enabled,
      onCheckedChange = {
        superBasicBoringViewModel.switch1Toggled()
      })
    Switch(
      superBasicBoringViewModel.switch2Enabled,
      onCheckedChange = {
        superBasicBoringViewModel.switch2Toggled()
      })
    Switch(
      superBasicBoringViewModel.switch3Enabled,
      onCheckedChange = {
        superBasicBoringViewModel.switch3Toggled()
      })
    Button(
      onClick = {
        superBasicBoringViewModel.uncheckAll()
      }
    ) {
      Text("uncheck all")
    }
  }
}

