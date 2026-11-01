package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class VeryBasicActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val box1Checked = mutableStateOf(true)
    val box2Checked = mutableStateOf(true)
    val box3Checked = mutableStateOf(true)
    val box4Checked = mutableStateOf(true)

    setContent {
      Column {
        ClicksCount(
          box1Checked,
          box2Checked,
          box3Checked,
          box4Checked
        )
      }
    }
  }
}

@Composable
fun ClicksCount(
  box1Checked: MutableState<Boolean>,
  box2Checked: MutableState<Boolean>,
  box3Checked: MutableState<Boolean>,
  box4Checked: MutableState<Boolean>,
) {
  var box1CheckedRemembered by remember {
    box1Checked
  }
  Checkbox(
    box1CheckedRemembered,
    onCheckedChange = {
      box1CheckedRemembered = it
    })

  var box2CheckedRemembered by remember {
    box2Checked
  }
  Checkbox(
    box2CheckedRemembered,
    onCheckedChange = {
      box2CheckedRemembered = it
    })

  var box3CheckedRemembered by remember {
    box3Checked
  }
  Checkbox(
    box3CheckedRemembered,
    onCheckedChange = {
      box3CheckedRemembered = it
    })

  var box4CheckedRemembered by remember {
    box4Checked
  }
  Checkbox(
    box4CheckedRemembered,
    onCheckedChange = {
      box4CheckedRemembered = it
    })
}
