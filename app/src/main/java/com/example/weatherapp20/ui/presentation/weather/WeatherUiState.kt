package com.example.weatherapp20.ui.presentation.weather

import com.example.weatherapp20.ui.domain.model.Weather

data class WeatherUiState(
    val searchQuery: String = "Sarajevo",
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val errorMessage: String? = null
)
