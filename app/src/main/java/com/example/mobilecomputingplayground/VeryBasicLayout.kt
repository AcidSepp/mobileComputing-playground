package com.example.mobilecomputingplayground

import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier

@Composable
fun VeryBasicLayout(veryBasicContent: @Composable () -> Unit) {
  Scaffold(
    modifier = Modifier.fillMaxSize()
  ) {
    Column(
      modifier = Modifier
        .padding(it)
        .fillMaxSize(),
      verticalArrangement = Center,
      horizontalAlignment = CenterHorizontally
    ) {
      veryBasicContent()
    }
  }
}
