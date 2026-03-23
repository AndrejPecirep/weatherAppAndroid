package com.example.weatherapp20.ui.data.model

import com.google.gson.annotations.SerializedName

data class ForecastResponseDto(
    @SerializedName("current")
    val current: CurrentWeatherDto,
    @SerializedName("daily")
    val daily: DailyWeatherDto
)

data class CurrentWeatherDto(
    @SerializedName("temperature_2m")
    val temperature: Double,
    @SerializedName("apparent_temperature")
    val apparentTemperature: Double,
    @SerializedName("relative_humidity_2m")
    val humidity: Int,
    @SerializedName("wind_speed_10m")
    val windSpeed: Double,
    @SerializedName("weather_code")
    val weatherCode: Int,
    @SerializedName("is_day")
    val isDay: Int
)

data class DailyWeatherDto(
    @SerializedName("time")
    val dates: List<String>,
    @SerializedName("weather_code")
    val weatherCodes: List<Int>,
    @SerializedName("temperature_2m_max")
    val maxTemperatures: List<Double>,
    @SerializedName("temperature_2m_min")
    val minTemperatures: List<Double>
)
