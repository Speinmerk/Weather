package ru.speinmerk.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowMessage(getString(R.string.on_create));
    }

    @Override
    protected void onStart() {
        super.onStart();
        ShowMessage(getString(R.string.on_start));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ShowMessage(getString(R.string.on_resume));
    }

    @Override
    protected void onPause() {
        super.onPause();
        ShowMessage(getString(R.string.on_pause));
    }

    @Override
    protected void onStop() {
        super.onStop();
        ShowMessage(getString(R.string.on_stop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ShowMessage(getString(R.string.on_destroy));
    }

    private void ShowMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.i(getClass().getSimpleName(), message);
    }
}
