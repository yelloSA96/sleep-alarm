package me.thomassuebwicha.ui.tester

import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun SnackbarTestComponent() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                icon = {  },
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("I'm in a league of my own")
                    }
                }
            )
        }
    ) { contentPadding ->
        Text("THis is some incredible development")
    }
}

@Preview
@Composable
fun SnackbarTestComponentPreview() {
    SnackbarTestComponent()
}