package me.thomassuebwicha.ui.tester

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import java.util.Calendar
import java.util.Locale
import android.util.Log

@Composable
fun TimePickerTestComponent() {
    var showTimePicker by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf<Calendar?>(null) }
    Log.i("TimePicker", "Recomposing TimePickerInDialogExample initial Render")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showTimePicker = true }) {
            Text(text = "Select Time")
        }

        if (showTimePicker) {
            Log.i("TimePicker", "showTimePicker is true, showing TimePickerDialog")
            TimePickerDialog(
                onDismissRequest = { showTimePicker = false },
                onConfirm = { hour, minute ->
                    selectedTime = Calendar.getInstance().apply{
                        set(Calendar.HOUR_OF_DAY, hour)
                        set(Calendar.MINUTE, minute)
                    }
                    showTimePicker = false
                }
            )
        }

        selectedTime?.let {
            Text("Selected time: ${String.format(Locale.ENGLISH,"%02d:%02d", it.get(Calendar.HOUR_OF_DAY), it.get(Calendar.MINUTE))}")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialog(
    onDismissRequest: () -> Unit,
    onConfirm: (hour: Int, minute: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val currentTime = Calendar.getInstance()
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true
    )

    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            modifier = modifier
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TimePicker(state = timePickerState, modifier = Modifier.padding(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismissRequest) {
                        Text("CANCEL")
                    }
                    TextButton(
                        onClick = { onConfirm(timePickerState.hour, timePickerState.minute) }
                    ) {
                        Text("OK")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun DemoPreview() {
    MaterialTheme {
        TimePickerTestComponent()
    }
}