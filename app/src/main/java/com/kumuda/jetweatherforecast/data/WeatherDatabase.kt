package com.kumuda.jetweatherforecast.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kumuda.jetweatherforecast.model.Favorite
import com.kumuda.jetweatherforecast.model.Unit


@Database(entities = [Favorite::class, Unit::class],version = 2)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao



}