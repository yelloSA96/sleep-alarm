package me.thomassuebwicha.ui.screens

import android.util.Log
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import me.thomassuebwicha.ui.tester.TimePickerDialog
import me.thomassuebwicha.viewmodels.setAlarm
import java.util.Calendar
import java.util.Locale

@Composable
fun SleepAlarmScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    var displayableHour by remember { mutableIntStateOf(calendar.get(Calendar.HOUR_OF_DAY)) }
    var displayableMinute by remember { mutableIntStateOf(calendar.get(Calendar.MINUTE)) }
    var selectedTime by remember { mutableStateOf<Calendar?>(null) }
    var showTimePicker by remember { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Select your wake up time",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(40.dp))


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
                    val totalMinutes = displayableHour * 60 + displayableMinute + 90
                    displayableHour = (totalMinutes / 60) % 24
                    displayableMinute = totalMinutes % 60
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("+1.5 Hr")
            }

            Button(
                onClick = {
                    displayableHour = (displayableHour + 3) % 24
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
                    val totalMinutes = displayableHour * 60 + displayableMinute + 270
                    displayableHour = (totalMinutes / 60) % 24
                    displayableMinute = totalMinutes % 60
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("+4.5 Hr")
            }

            Button(
                onClick = {
                    displayableHour = (displayableHour + 6) % 24
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
                    val totalMinutes = displayableHour * 60 + displayableMinute + 450
                    displayableHour = (totalMinutes / 60) % 24
                    displayableMinute = totalMinutes % 60
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("+7.5 Hr")
            }

            Button(
                onClick = {
                    displayableHour = (displayableHour + 9) % 24
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("+9 Hr")
            }
        }

        Button(
            colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.background,
                disabledContainerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
                disabledContentColor = MaterialTheme.colorScheme.onBackground
            ),
            onClick = {
                showTimePicker = true
            },
        ) {
            Text(
                text = String.format(Locale.ENGLISH, "%02d:%02d", displayableHour, displayableMinute),
                fontSize = 58.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    setAlarm(context, displayableHour, displayableMinute, "Made by Sleep Application!")
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Set Sleep Alarm")
            }
        }


        if (showTimePicker) {
            Log.i("TimePicker", "showTimePicker is true, showing TimePickerDialog")
            TimePickerDialog(
                onDismissRequest = { showTimePicker = false },
                onConfirm = { hour, minute ->
                    displayableHour = hour
                    displayableMinute = minute
                    showTimePicker = false
                }
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialPickerWidget(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    Column {
        TimePicker(
            state = timePickerState,
        )
        Button(onClick = onDismiss) {
            Text("Dismis Picker")
        }
        Button(onClick = onConfirm) {
            Text("Confirm selection")
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SleepAlarmsScreenPreview() {
    MaterialTheme {
        val navController = rememberNavController()
        SleepAlarmScreen(navController)
    }
}
