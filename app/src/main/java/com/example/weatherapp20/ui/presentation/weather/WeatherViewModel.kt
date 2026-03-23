package com.example.weatherapp20.ui.presentation.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.weatherapp20.ui.core.network.RetrofitInstance
import com.example.weatherapp20.ui.core.util.Resource
import com.example.weatherapp20.ui.data.repository.WeatherRepositoryImpl
import com.example.weatherapp20.ui.domain.usecase.GetWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(WeatherUiState())
    val state: StateFlow<WeatherUiState> = _state.asStateFlow()

    init {
        fetchWeather()
    }

    fun onQueryChange(value: String) {
        _state.update { it.copy(searchQuery = value, errorMessage = null) }
    }

    fun fetchWeather(city: String = state.value.searchQuery) {
        viewModelScope.launch {
            getWeatherUseCase(city).collect { result ->
                when (result) {
                    is Resource.Idle -> Unit
                    is Resource.Loading -> {
                        _state.update {
                            it.copy(isLoading = true, errorMessage = null)
                        }
                    }
                    is Resource.Success -> {
                        _state.update {
                            it.copy(
                                isLoading = false,
                                weather = result.data,
                                errorMessage = null,
                                searchQuery = result.data.cityName
                            )
                        }
                    }
                    is Resource.Error -> {
                        _state.update {
                            it.copy(isLoading = false, errorMessage = result.message)
                        }
                    }
                }
            }
        }
    }

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val api = RetrofitInstance.api
                val repository = WeatherRepositoryImpl(api)
                val useCase = GetWeatherUseCase(repository)
                @Suppress("UNCHECKED_CAST")
                return WeatherViewModel(useCase) as T
            }
        }
    }
}
