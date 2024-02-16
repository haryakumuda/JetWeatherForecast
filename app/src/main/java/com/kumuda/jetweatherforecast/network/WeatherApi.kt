package com.kumuda.jetweatherforecast.network

import com.kumuda.jetweatherforecast.model.Weather
import com.kumuda.jetweatherforecast.utils.Constans
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton


@Singleton
interface WeatherApi {
    @GET(value = "data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") city: String = "bogor",
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = Constans.API_KEY,
        ): Weather

    @GET(value = "data/2.5/forecast/daily")
    suspend fun getGeolocation(
        @Query("q") query: String = "bogor,id",
        @Query("limit") limit: String = "5",
        @Query("appid") appid: String = Constans.API_KEY,
    ): Unit
}