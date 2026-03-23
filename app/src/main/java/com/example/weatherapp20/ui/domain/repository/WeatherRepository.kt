package com.example.weatherapp20.ui.domain.repository

import com.example.weatherapp20.ui.core.util.Resource
import com.example.weatherapp20.ui.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeather(city: String): Flow<Resource<Weather>>
}
