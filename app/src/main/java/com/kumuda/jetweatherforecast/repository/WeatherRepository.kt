package com.kumuda.jetweatherforecast.repository

import android.util.Log
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
            Log.d("INSIDE", "getWeather: $e")
            return DataOrException(e = e)
        }
        Log.d("INSIDE", "getWeather: $response")



        return DataOrException(data = response)


    }
}