package com.javeria.newsinshort.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.javeria.newsinshort.ui.navigation.Routes.HOME_SCREEN
import com.javeria.newsinshort.ui.screens.HomeScreen
import com.javeria.newsinshort.ui.viewmodel.NewsViewModel

@Composable
fun AppNavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME_SCREEN) {
        composable(HOME_SCREEN) {
            HomeScreen()
        }
    }
}