package com.example.weatherapp20.ui.domain.usecase

import com.example.weatherapp20.ui.core.util.Resource
import com.example.weatherapp20.ui.domain.model.Weather
import com.example.weatherapp20.ui.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class GetWeatherUseCase(
    private val repository: WeatherRepository
) {
    operator fun invoke(city: String): Flow<Resource<Weather>> = repository.getWeather(city)
}
