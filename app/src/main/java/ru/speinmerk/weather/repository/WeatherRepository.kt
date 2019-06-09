package ru.speinmerk.weather.repository

import io.reactivex.Observable
import ru.speinmerk.weather.BuildConfig
import ru.speinmerk.weather.model.WeatherRequest
import ru.speinmerk.weather.repository.retrofit.ApiWeather

class WeatherRepository {
    val apiWeather = ApiWeather.create()

    fun loadWeather(cityCode: String): Observable<WeatherRequest> =
            apiWeather.loadWeather(cityCountry = cityCode, keyApi = BuildConfig.API_KEY)
}