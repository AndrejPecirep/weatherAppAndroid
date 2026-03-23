package com.example.weatherapp20.ui.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp20.ui.presentation.weather.WeatherScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Weather.route) {
        composable(Routes.Weather.route) { WeatherScreen() }
    }
}