package ru.speinmerk.weather.fragment.CityList;

import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import ru.speinmerk.weather.model.City;

interface CityListContract {
    interface View {
        void showCities(ArrayList<City> cities);
        void showAddCityFragment();
        void showCityWeatherFragment(City city);
    }
    interface Presenter {
        void attachView(View view);
        void detachView();
        void viewIsReady();
        void onSelectedCity(City city);
        void onAddCity();
        void onResultAddCityFragment(Intent intent);
    }
    interface Model {
        Flowable<List<City>> getCities();
        void addCity(City city);
        void updateWeather(City city);

    }
}
