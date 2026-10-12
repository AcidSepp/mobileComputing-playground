package com.example.mobilecomputingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme

class StandardComponentsActivity : ComponentActivity() {

  val viewModel by viewModels<StandardComponentsViewModel>()

  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      MobileComputingPlaygroundTheme() {
        Scaffold(
          topBar = {
            TopAppBar(
              title = {
                Text("Eine TopAppBar")
              },
              colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
              ),
            )
          },
          bottomBar = {
            BottomAppBar() {
              Text(viewModel.textFieldState)
            }
          },
          content = {
            Content(
              it,
              viewModel
            )
          })
      }
    }
  }
}

@Composable
fun Content(paddingValues: PaddingValues, viewModel: StandardComponentsViewModel) {
  Column(
    modifier = Modifier
      .padding(paddingValues)
      .fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      "Hello",
      fontSize = 36.sp
    )

    Button(onClick = {
      viewModel.reset()
    }) {
      Text(
        "My First Button :)",
        fontSize = 36.sp
      )
    }

    Switch(
      viewModel.switchState,
      onCheckedChange = {
        viewModel.toggleSwitch()
      })

    Checkbox(
      viewModel.checkBoxState,
      onCheckedChange = {
        viewModel.toggleCheckBox()
      })

    OutlinedTextField(
      viewModel.textFieldState,
      onValueChange = {
        viewModel.enterText(it)
      })

    Image(
      painterResource(R.drawable.haw_landshut),
      "HAW Landshut Logo",
      modifier = Modifier
        .clickable {

        }
        .padding(
          top = 10.dp,
          bottom = 10.dp
        ))
  }
}
