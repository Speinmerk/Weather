package ru.speinmerk.weather.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ru.speinmerk.weather.R
import ru.speinmerk.weather.view.CityListFragment

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.container, CityListFragment.newInstance())
                .addToBackStack(null)
                .commit()
    }
}