package ru.speinmerk.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.speinmerk.weather.models.City;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowMessage(getString(R.string.on_create));

        EditText etCity = findViewById(R.id.et_city);
        Button btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(v -> {
            String nameCity = etCity.getText().toString();
            if (nameCity.isEmpty()) {
                Toast.makeText(getApplicationContext(), getString(R.string.enter_city), Toast.LENGTH_SHORT).show();
            } else {
                startActivityWeatherForCity(new City(nameCity,25, 50, 5, 750));
            }
        });
    }

    private void startActivityWeatherForCity(City city) {
        Intent intent = new Intent(this, WeatherForCity.class);
        intent.putExtra(City.KEY_PARCELABLE, city);
        startActivity(intent);
    }

    private void ShowMessage(String message) {
        Log.i(getClass().getSimpleName(), message);
    }
}
