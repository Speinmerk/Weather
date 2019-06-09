package ru.speinmerk.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherInfo(
        @SerializedName("temp")
        val temperature: Float,
        val pressure: Int,
        val humidity: Int,
        @SerializedName("temp_min")
        val temperatureMaximum: Float,
        @SerializedName("temp_max")
        val temperatureMinimum: Float,
        @SerializedName("sea_level")
        val pressureSeaLevel: Int,
        @SerializedName("grnd_level")
        val pressureGroundLevel: Int
)