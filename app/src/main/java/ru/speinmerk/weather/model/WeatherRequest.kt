package ru.speinmerk.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherRequest (
        @SerializedName("coord")
        val coordinate: Coordinate,
        val weather: ArrayList<Weather>,
        val base: String,
        @SerializedName("main")
        val weatherInfo: WeatherInfo,
        val visibility: Int,
        val wind: Wind,
        @SerializedName("clouds")
        val cloudiness: Cloudiness,
        @SerializedName("dt")
        val date: Long,
        @SerializedName("sys")
        val system: WeatherSystem,
        @SerializedName("id")
        val cityId: Int,
        @SerializedName("name")
        val cityName: String,
        @SerializedName("cod")
        val code: Int
)