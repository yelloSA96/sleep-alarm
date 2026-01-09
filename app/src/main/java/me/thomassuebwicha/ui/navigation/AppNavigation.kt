package me.thomassuebwicha.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import me.thomassuebwicha.ui.screens.SelectionScreen
import me.thomassuebwicha.ui.screens.SleepAlarmScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.HOME
    ) {
        composable(NavigationRoutes.HOME) {
            SelectionScreen(navController = navController)
        }

        composable(NavigationRoutes.ALARM_SCREEN) {
            SleepAlarmScreen(navController = navController)
        }
    }
}