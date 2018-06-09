package ru.speinmerk.weather.room;

import android.app.Application;
import android.arch.persistence.room.Room;

class App : Application() {
    companion object {
        lateinit var instance: App
    }
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
                .fallbackToDestructiveMigration()
                .build()
    }
}