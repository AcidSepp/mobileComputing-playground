package com.example.mobilecomputingplayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperBasicBoringLayout(
  boringTitle: String? = null,
  bottomBarBoringTitle: String? = null,
  content: @Composable () -> Unit,
) {
  Scaffold(
    topBar = {
      if (boringTitle != null) {
        TopAppBar(title = {
          Text(boringTitle)
        })
      }
    },
    content = {
      Column(
        modifier = Modifier
          .padding(it)
          .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        content()
      }
    },
    bottomBar = {
      if (bottomBarBoringTitle != null) {
        BottomAppBar {
          Text(bottomBarBoringTitle)
        }
      }
    }
  )
}
