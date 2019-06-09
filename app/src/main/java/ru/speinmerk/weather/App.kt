package ru.speinmerk.weather

import android.app.Application
import android.arch.persistence.room.Room
import ru.speinmerk.weather.room.AppDatabase

class App : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}