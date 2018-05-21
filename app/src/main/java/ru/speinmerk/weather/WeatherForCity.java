package ru.speinmerk.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import ru.speinmerk.weather.models.City;

public class WeatherForCity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_for_city);

        City city = getIntent().getParcelableExtra(City.KEY_PARCELABLE);

        TextView tvCity = findViewById(R.id.tv_city);
        TextView tvTemperature = findViewById(R.id.tv_temperature);
        TextView tvHumidity = findViewById(R.id.tv_humidity);
        TextView tvWindSpeed = findViewById(R.id.tv_wind_speed);
        TextView tvPressure = findViewById(R.id.tv_pressure);

        tvCity.setText(String.format("Город %s", city.name));
        tvTemperature.setText(String.format("Температура: %s", city.temperature));
        tvHumidity.setText(String.format("Влажность: %s", city.humidity));
        tvWindSpeed.setText(String.format("Скорость ветра: %s м/с", city.windSpeed));
        tvPressure.setText(String.format("Давление: %s мм рт.ст.", city.pressure));

    }
}
