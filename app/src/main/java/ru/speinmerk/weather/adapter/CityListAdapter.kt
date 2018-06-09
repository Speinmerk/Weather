package ru.speinmerk.weather.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import java.util.ArrayList
import ru.speinmerk.weather.R
import ru.speinmerk.weather.model.City

class CityListAdapter internal constructor(private val listener: OnSelectedCityListener) : RecyclerView.Adapter<CityListAdapter.ViewHolder>() {

    private val cities = ArrayList<City>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_city_list, parent, false)
        return ViewHolder(view as TextView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cities[position])
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    fun setData(cities: List<City>) {
        this.cities.clear()
        this.cities.addAll(cities)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val textView: TextView) : RecyclerView.ViewHolder(textView) {
        fun bind(city: City) {
            textView.text = city.name
            textView.setOnClickListener { v -> listener.onSelectedCity(city) }
        }
    }

    internal interface OnSelectedCityListener {
        fun onSelectedCity(city: City)
    }
}
