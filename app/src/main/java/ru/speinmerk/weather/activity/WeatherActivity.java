package ru.speinmerk.weather.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import ru.speinmerk.weather.R;
import ru.speinmerk.weather.fragment.CityList.CityListFragment;

public class WeatherActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, CityListFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
}