package com.example.weatherapp20.ui.domain.model

data class Weather(
    val cityName: String,
    val country: String,
    val latitude: Double,
    val longitude: Double,
    val temperature: Double,
    val apparentTemperature: Double,
    val weatherCode: Int,
    val humidity: Int,
    val windSpeed: Double,
    val isDay: Boolean,
    val dailyForecast: List<ForecastDay>
)

data class ForecastDay(
    val date: String,
    val minTemperature: Double,
    val maxTemperature: Double,
    val weatherCode: Int
)
