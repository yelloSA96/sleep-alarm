package me.thomassuebwicha.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import me.thomassuebwicha.viewmodels.setAlarm
import java.util.Calendar
import java.util.Locale

@Composable
fun WakeUpTimeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { contentPadding ->
        val context = LocalContext.current
        val calendar = Calendar.getInstance()
        var hour by remember { mutableIntStateOf(0) }
        var minute by remember { mutableIntStateOf(0) }
        val timeString = String.format(Locale.ENGLISH, "%02d:%02d", hour, minute)
        Column(
            modifier = modifier
                .padding(contentPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Select your wake up time",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                colors = ButtonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    disabledContainerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onBackground,
                    disabledContentColor = MaterialTheme.colorScheme.onBackground
                ),
                onClick = {
                    val currentCalendar = Calendar.getInstance()
                    hour = currentCalendar.get(Calendar.HOUR_OF_DAY)
                    minute = currentCalendar.get(Calendar.MINUTE)
                    scope.launch {
                        snackbarHostState.showSnackbar("Reset back to current time!", duration = SnackbarDuration.Short)
                    }
                },
            ) {
                Text(
                    text = timeString,
                    fontSize = 58.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.height(40.dp))

            // Grid for buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        val totalMinutes = hour * 60 + minute + 90
                        hour = (totalMinutes / 60) % 24
                        minute = totalMinutes % 60
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("+1.5 Hr")
                }

                Button(
                    onClick = {
                        hour = (hour + 3) % 24
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("+3.0 Hr")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        val totalMinutes = hour * 60 + minute + 270
                        hour = (totalMinutes / 60) % 24
                        minute = totalMinutes % 60
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("+4.5 Hr")
                }

                Button(
                    onClick = {
                        hour = (hour + 6) % 24
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("+6 Hr")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        val totalMinutes = hour * 60 + minute + 450
                        hour = (totalMinutes / 60) % 24
                        minute = totalMinutes % 60
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("+7.5 Hr")
                }

                Button(
                    onClick = {
                        hour = (hour + 9) % 24
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("+9 Hr")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        setAlarm(context, hour, minute, "Made by Sleep Application!")
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Set Alarm")
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WakeUpTimeScreenPreview() {
    MaterialTheme {
        val navController = rememberNavController()
        WakeUpTimeScreen(navController)
    }
}
