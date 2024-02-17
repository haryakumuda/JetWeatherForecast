package com.kumuda.jetweatherforecast.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kumuda.jetweatherforecast.model.Favorite


@Database(entities = [Favorite::class],version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

}