package ru.speinmerk.weather.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.speinmerk.weather.R;
import ru.speinmerk.weather.model.City;

public class CityWeatherFragment extends Fragment {

    public static CityWeatherFragment newInstance(City city) {

        Bundle args = new Bundle();
        args.putParcelable(City.KEY_PARCELABLE, city);
        CityWeatherFragment fragment = new CityWeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_city_weather, container, false);
    }
}
