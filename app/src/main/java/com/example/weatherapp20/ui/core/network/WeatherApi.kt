package com.example.weatherapp20.ui.core.network

import com.example.weatherapp20.ui.data.model.ForecastResponseDto
import com.example.weatherapp20.ui.data.model.GeocodingResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/search")
    suspend fun searchCity(
        @Query("name") city: String,
        @Query("count") count: Int = 1,
        @Query("language") language: String = "en",
        @Query("format") format: String = "json"
    ): GeocodingResponseDto

    @GET("https://api.open-meteo.com/v1/forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String = "temperature_2m,apparent_temperature,relative_humidity_2m,weather_code,wind_speed_10m,is_day",
        @Query("daily") daily: String = "weather_code,temperature_2m_max,temperature_2m_min",
        @Query("forecast_days") forecastDays: Int = 7,
        @Query("timezone") timezone: String = "auto"
    ): ForecastResponseDto
}
