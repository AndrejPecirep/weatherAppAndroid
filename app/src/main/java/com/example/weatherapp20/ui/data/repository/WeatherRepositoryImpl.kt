package com.example.weatherapp20.ui.data.repository

import com.example.weatherapp20.ui.core.network.WeatherApi
import com.example.weatherapp20.ui.core.util.Resource
import com.example.weatherapp20.ui.data.mapper.toDomain
import com.example.weatherapp20.ui.domain.model.Weather
import com.example.weatherapp20.ui.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WeatherRepositoryImpl(
    private val api: WeatherApi
) : WeatherRepository {

    override fun getWeather(city: String): Flow<Resource<Weather>> = flow {
        emit(Resource.Loading)

        if (city.isBlank()) {
            emit(Resource.Error("Unesi naziv grada."))
            return@flow
        }

        try {
            val location = api.searchCity(city.trim()).results?.firstOrNull()
            if (location == null) {
                emit(Resource.Error("Grad nije pronađen. Provjeri unos i pokušaj ponovo."))
                return@flow
            }

            val forecast = api.getWeather(
                latitude = location.latitude,
                longitude = location.longitude
            )

            emit(Resource.Success(forecast.toDomain(location)))
        } catch (_: IOException) {
            emit(Resource.Error("Nema mrežne veze. Provjeri internet i pokušaj ponovo."))
        } catch (e: HttpException) {
            emit(Resource.Error("Greška servera (${e.code()}). Pokušaj malo kasnije."))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Došlo je do neočekivane greške."))
        }
    }
}
