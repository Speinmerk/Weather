package ru.speinmerk.weather.fragment.CityList;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import ru.speinmerk.weather.model.City;

public class CityListPresenter implements CityListContract.Presenter {

    private CityListContract.View view;
    private final CityListContract.Model model;
    private ArrayList<City> cities = new ArrayList<>();

    CityListPresenter(CityListContract.Model model) {
        this.model = model;
    }

    @Override
    public void attachView(CityListContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void viewIsReady() {
        model.updateWeather(null);
        model.getCities().observeOn(AndroidSchedulers.mainThread())
                .subscribe(cities -> {
                    this.cities.clear();
                    this.cities.addAll(cities);
                    view.showCities(this.cities);
                });
    }

    @Override
    public void onSelectedCity(City city) {
        view.showCityWeatherFragment(city);
    }

    @Override
    public void onAddCity() {
        view.showAddCityFragment();
    }

    @Override
    public void onResultAddCityFragment(Intent intent) {
        City city = intent.getParcelableExtra(City.KEY_PARCELABLE);
        model.addCity(city);
    }


}
