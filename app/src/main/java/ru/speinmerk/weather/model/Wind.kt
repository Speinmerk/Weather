package ru.speinmerk.weather.model

import com.google.gson.annotations.SerializedName

data class Wind(
        val speed: Float,
        @SerializedName("deg")
        val direction: Int
)