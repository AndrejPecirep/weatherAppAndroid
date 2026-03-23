package com.example.weatherapp20.ui.presentation.navigation

sealed class Routes(val route: String) {
    object Weather : Routes("weather")
}