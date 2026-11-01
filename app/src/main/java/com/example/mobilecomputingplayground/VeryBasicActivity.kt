package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class VeryBasicActivity : ComponentActivity() {

  val veryBasicViewModel by viewModels<VeryBasicViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      VeryBasicLayout {
        VeryBasic(
          veryBasicViewModel
        )
      }
    }
  }
}

@Composable
fun VeryBasic(
  veryBasicViewModel: VeryBasicViewModel,
) {
  Button(onClick = {
    veryBasicViewModel.uncheckAllBoxes()
  }) {
    Text("Uncheck all")
  }
  Checkbox(
    veryBasicViewModel.box1Checked,
    onCheckedChange = {
      veryBasicViewModel.toggleBox1()
    })
  Checkbox(
    veryBasicViewModel.box2Checked,
    onCheckedChange = {
      veryBasicViewModel.toggleBox2()
    })
  Checkbox(
    veryBasicViewModel.box3Checked,
    onCheckedChange = {
      veryBasicViewModel.toggleBox3()
    })
}
