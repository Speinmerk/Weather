package ru.speinmerk.weather.room;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {
    private static App instance;
    private AppDatabase database;

    public static App getInstance() {
        return instance;
    }
    public AppDatabase getDatabase() {
        return database;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .fallbackToDestructiveMigration()
                .build();
    }
}