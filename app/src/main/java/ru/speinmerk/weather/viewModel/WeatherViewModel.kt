package ru.speinmerk.weather.viewModel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.speinmerk.weather.model.City
import ru.speinmerk.weather.room.App
import ru.speinmerk.weather.adapter.CityListAdapter


class WeatherViewModel : ViewModel(), CityListAdapter.OnSelectedCityListener {
    val adapter = CityListAdapter(this)
    private val cities = ArrayList<City>()
    private val db = App.instance.database
    private val cityDao = db.cityDao()
    private val cityAllListener = cityDao.getAllListener()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun init() {
        cityAllListener.observeOn(AndroidSchedulers.mainThread()).subscribe({ onCitiesGetDB(it) })
    }

    private fun onCitiesGetDB(cities: List<City>) {
        this.cities.clear()
        this.cities.addAll(cities)
        adapter.setData(this.cities)
    }

    override fun onSelectedCity(city: City) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}