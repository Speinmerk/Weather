package ru.speinmerk.weather.repository

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso
import ru.speinmerk.weather.BuildConfig

class PicassoRepository private constructor(private val picasso: Picasso) {

    companion object {
        fun instance(context: Context) = PicassoRepository(Picasso.with(context))
    }

    fun loadWeatherImage(icon: String, imageView: ImageView) = picasso
            .load("${BuildConfig.REST_IMAGE_WEATHER}img/w/$icon.png")
            .into(imageView)
}