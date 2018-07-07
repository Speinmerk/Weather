package ru.speinmerk.weather.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ru.speinmerk.weather.model.City
import ru.speinmerk.weather.room.dao.CityDao

@Database(entities = [(City::class)], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cityDao(): CityDao
}