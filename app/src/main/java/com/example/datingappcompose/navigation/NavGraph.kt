package com.example.datingappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.datingappcompose.presentation.screens.splash.SplashScreen
import com.example.datingappcompose.presentation.screens.welcome.WelcomeScreen

@Composable
fun SetupNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navHostController = navController)
        }
        composable(Screen.Welcome.route) {
            WelcomeScreen(navHostController = navController)
        }


    }
}