package ru.speinmerk.weather.view;

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.speinmerk.weather.BR
import ru.speinmerk.weather.R
import ru.speinmerk.weather.databinding.FragmentCityListBinding
import ru.speinmerk.weather.viewModel.WeatherViewModel

class CityListFragment : Fragment() {
    companion object {
        fun newInstance() = CityListFragment()
    }
    private lateinit var viewModel: WeatherViewModel
    private lateinit var binding: FragmentCityListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_city_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
    }
}