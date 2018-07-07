package ru.speinmerk.weather.model;

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "city")
data class City(
        @PrimaryKey
        val code: String,
        val name: String
)