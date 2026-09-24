package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NavUtils
import com.example.mobilecomputingplayground.ui.theme.MobileComputingPlaygroundTheme

class ChildActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MobileComputingPlaygroundTheme {

                ChildActivityLayout(
                    {
                        val upIntent =
                            NavUtils.getParentActivityIntent(this@ChildActivity)!!
                        navigateUpTo(upIntent)
                    },
                    buttonOnClick = {
                        setResult(1337)
                        finish()
                    })
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun ChildActivityLayout(
        onNavigationItemClicked: () -> Unit = {},
        contentMutableState: MutableState<String> = mutableStateOf("No Devices found"),
        buttonOnClick: () -> Unit = {},
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            ChildActivity::class.simpleName.toString(),
                            textAlign = TextAlign.Right
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onNavigationItemClicked) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = buttonOnClick,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Finish!")
                    }
                }
            })
    }
}
