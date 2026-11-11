package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val mutableStateOfList: MutableState<List<String>> = mutableStateOf(
      listOf(
        "a",
        "b",
        "c"
      )
    )

    setContent {
      ButtonClickDingsi(mutableStateOfList)
    }
    Thread({
             Thread.sleep(3_000)
             val value = mutableStateOfList.value
             val result = mutableListOf<String>();
             result.addAll(value)
             result.add("hinten was dran und so")
             mutableStateOfList.value = result.toMutableList()
           }).start()
  }
}

@Composable
fun ButtonClickDingsi(list: MutableState<List<String>>) {
  var rememberedList by remember {
    list
  }
  SuperBasicBoringLayout {
    for (string in rememberedList) {
      Text(string)
    }
  }
}

