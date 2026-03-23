package com.example.weatherapp20.ui.data.model

import com.google.gson.annotations.SerializedName

data class GeocodingResponseDto(
    @SerializedName("results")
    val results: List<LocationDto>?
)

data class LocationDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
)
