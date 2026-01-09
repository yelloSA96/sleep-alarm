package me.thomassuebwicha.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import me.thomassuebwicha.ui.navigation.NavigationRoutes


@Composable
fun SelectionScreen(
    navController: NavController,
    onTabSelected: (Int) -> Unit = {},
    onHistoryClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        // Title
        Text(
            text = "Sleep\nAlarms",
            style = MaterialTheme.typography.displayLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 56.sp,
                lineHeight = 64.sp
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Description
        Text(
            text = "Sleep Alarms is a 90 min cycle calculator with suggestions on ideal wake up at the end of a sleep cycle.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Text(
            text = "This tool takes into account how long you take to fall asleep and your regular wake-up time. We've paired this calculator with a short text, describing:",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Bullet points
        Column(
            modifier = Modifier.padding(start = 1.dp, bottom = 24.dp)
        ) {
            BulletPoint("The benefits of a regular sleep schedule;")
            BulletPoint("What sleep cycles are or 90-minute sleep blocks are;")
            BulletPoint("Risks of sleep deprivation;")
            BulletPoint("The best times to sleep and wake up based on your needs.")
        }

        Spacer(modifier = Modifier.weight(1f))

        // Tab Row
        SleepTabRow(
            navController = navController,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // History Button
        Button(
            onClick = onHistoryClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_save),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "History",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun BulletPoint(text: String) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Text(
            text = "• ",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun SleepTabRow(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    var selectedIndex by remember { mutableIntStateOf(-1) }
    val options = listOf("Bed Time Now", "Sleep Time", "Wake Up Time")

    SingleChoiceSegmentedButtonRow(
        modifier = modifier.fillMaxWidth()
    ) {
        options.forEachIndexed { index, title ->
            SegmentedButton(
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = options.size
                ),
                onClick = {
                    selectedIndex = index
                    when (index) {
                        0 -> navController.navigate(NavigationRoutes.ALARM_SCREEN)
                        1 -> navController.navigate("sleep_time")
                        2 -> navController.navigate("wake_up_time")
                    }
                },
                selected = index == selectedIndex,
                icon = {},
                label = { Text(title)}
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SleepAlarmsIntroScreenPreview() {
    MaterialTheme {
        val navController = rememberNavController()
        SelectionScreen(navController)
    }
}