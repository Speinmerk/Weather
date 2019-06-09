package ru.speinmerk.weather.model

import com.google.gson.annotations.SerializedName

data class Coordinate(
        @SerializedName("lon")
        val longitude: Float,
        @SerializedName("lat")
        val latitude: Float
)