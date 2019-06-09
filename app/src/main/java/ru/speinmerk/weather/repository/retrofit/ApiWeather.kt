package ru.speinmerk.weather.repository.retrofit

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ru.speinmerk.weather.BuildConfig
import ru.speinmerk.weather.model.WeatherRequest


interface ApiWeather {
    @GET("data/2.5/weather")
    fun loadWeather(@Query("q") cityCountry: String,
                    @Query("appid") keyApi: String): Observable<WeatherRequest>

    companion object Factory {
        fun create(): ApiWeather {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BuildConfig.REST_WEATHER)
                    .build()
            return retrofit.create(ApiWeather::class.java)
        }
    }
}