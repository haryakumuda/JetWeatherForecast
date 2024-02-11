package com.kumuda.jetweatherforecast.repository

import com.kumuda.jetweatherforecast.data.DataOrException
import com.kumuda.jetweatherforecast.model.Weather
import com.kumuda.jetweatherforecast.network.WeatherApi
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class WeatherRepository @Inject constructor(private val api: WeatherApi) {

    suspend fun getWeather(
        latitude: String,
        longitude: String,
        units: String
    ): DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(latitude, longitude)
        } catch (e: Exception) {
            return DataOrException(e = e)
        }

        return DataOrException()


    }
}