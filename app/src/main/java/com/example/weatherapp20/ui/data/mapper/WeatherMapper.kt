package com.example.weatherapp20.ui.data.mapper

import com.example.weatherapp20.ui.data.model.ForecastResponseDto
import com.example.weatherapp20.ui.data.model.LocationDto
import com.example.weatherapp20.ui.domain.model.ForecastDay
import com.example.weatherapp20.ui.domain.model.Weather

fun ForecastResponseDto.toDomain(location: LocationDto): Weather {
    val forecast = daily.dates.indices.map { index ->
        ForecastDay(
            date = daily.dates[index],
            minTemperature = daily.minTemperatures.getOrElse(index) { 0.0 },
            maxTemperature = daily.maxTemperatures.getOrElse(index) { 0.0 },
            weatherCode = daily.weatherCodes.getOrElse(index) { 0 }
        )
    }

    return Weather(
        cityName = location.name,
        country = location.country,
        latitude = location.latitude,
        longitude = location.longitude,
        temperature = current.temperature,
        apparentTemperature = current.apparentTemperature,
        weatherCode = current.weatherCode,
        humidity = current.humidity,
        windSpeed = current.windSpeed,
        isDay = current.isDay == 1,
        dailyForecast = forecast
    )
}
