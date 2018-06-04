package ru.speinmerk.weather.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import ru.speinmerk.weather.model.City;

@Dao
public interface CityDao {
    @Query("SELECT * FROM city")
    List<City> getAll();

    @Query("SELECT * FROM city")
    Flowable<List<City>> getAllListener();

    @Query("DELETE FROM city")
    void clearData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(City city);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<City> cities);

    @Delete
    void delete(City city);

}