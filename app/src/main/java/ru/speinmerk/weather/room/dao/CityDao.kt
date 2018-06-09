package ru.speinmerk.weather.room.dao

import android.arch.persistence.room.*
import io.reactivex.Flowable
import ru.speinmerk.weather.model.City

@Dao
interface CityDao {
    @Query("SELECT * FROM city")
    fun getAll(): List<City>

    @Query("SELECT * FROM city")
    fun getAllListener(): Flowable<List<City>>

    @Query("DELETE FROM city")
    fun clearData()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(city: City)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cities: List<City>)

    @Delete
    fun delete(city: City)
}

