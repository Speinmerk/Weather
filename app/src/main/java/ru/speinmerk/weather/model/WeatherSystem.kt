package ru.speinmerk.weather.model

data class WeatherSystem(
    val type: Int,
    val id: Int,
    val message: Double,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)