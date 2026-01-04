package me.thomassuebwicha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.thomassuebwicha.ui.screens.SelectionScreen
import me.thomassuebwicha.ui.screens.SleepAlarmScreen
import me.thomassuebwicha.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "selection_screen"
                    ) {
                        composable("selection_screen") {
                            SelectionScreen(navController = navController)
                        }

                        composable("sleep_alarm") {
                            SleepAlarmScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true
    )
@Composable
fun SleepAlarmActivityPreview() {
    MyApplicationTheme {
        val navController = rememberNavController()
        SleepAlarmScreen(navController)
    }
}