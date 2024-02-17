package com.kumuda.jetweatherforecast.repository

import com.kumuda.jetweatherforecast.data.WeatherDao
import com.kumuda.jetweatherforecast.model.City
import com.kumuda.jetweatherforecast.model.Favorite
import com.kumuda.jetweatherforecast.network.WeatherApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherDbRepository
@Inject
constructor(private val weatherDao: WeatherDao) {

    fun getFavorites(): Flow<List<Favorite>> = weatherDao.getFavorites()
    suspend fun insertFavorite(favorite: Favorite) = weatherDao.insertFavorite(favorite)
    suspend fun updateFavorite(favorite: Favorite)= weatherDao.updateFavorite(favorite)
    suspend fun deleteAllFavorite() = weatherDao.deleteAllFavorites()
    suspend fun deleteFavorite(favorite: Favorite) = weatherDao.deleteFavorite(favorite)
    suspend fun getFavById(city: String): Favorite = weatherDao.getFavById(city = city)

}
