package ru.speinmerk.weather.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.speinmerk.weather.R
import kotlinx.android.synthetic.main.adapter_city.view.*
import ru.speinmerk.weather.model.City

class CityAdapter(private val cities: List<City>) : RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_city, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cities[position]
        holder.mIdView.text = item.code
        holder.mContentView.text = item.name
    }

    override fun getItemCount(): Int = cities.size

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
