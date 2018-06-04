package ru.speinmerk.weather.fragment.CityList;

import java.util.List;

import io.reactivex.Flowable;
import ru.speinmerk.weather.model.City;
import ru.speinmerk.weather.room.App;
import ru.speinmerk.weather.room.AppDatabase;
import ru.speinmerk.weather.room.dao.CityDao;

public class CityListModel implements CityListContract.Model {
    private AppDatabase db = App.getInstance().getDatabase();
    private CityDao cityDao = db.cityDao();

    @Override
    public Flowable<List<City>> getCities() {
        return cityDao.getAllListener();
    }

    @Override
    public void addCity(City city) {
        if (city == null) return;
        new Thread(() -> cityDao.insert(city)).start();
    }

    @Override
    public void updateWeather(City currentCity) {
        new Thread(() -> {
            if (currentCity == null) {
                List<City> cities = cityDao.getAll();
                for (City city : cities) {
                    randomWeather(city);
                }
                cityDao.insertAll(cities);
            } else {
                randomWeather(currentCity);
                cityDao.insert(currentCity);
            }
        }).start();
    }

    private void randomWeather(City city) {
        city.temperature = (int) (Math.random() * 50 - 20);
        city.humidity = (int) (Math.random() * 90);
        city.windSpeed = (int) (Math.random() * 30);
        city.pressure = (int) (Math.random() * 20 + 740);
    }
}
