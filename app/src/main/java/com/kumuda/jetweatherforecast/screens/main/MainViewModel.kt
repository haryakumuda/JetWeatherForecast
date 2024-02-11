package com.kumuda.jetweatherforecast.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kumuda.jetweatherforecast.data.DataOrException
import com.kumuda.jetweatherforecast.model.Weather
import com.kumuda.jetweatherforecast.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {
    val data: MutableState<DataOrException<Weather, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("Error!")))

    init {
        loadWeather()
    }

    private fun loadWeather() {
        getWeather("-6.5944", "106.7892")
    }

    private fun getWeather(latitude: String, longitude: String) {
        viewModelScope.launch {
            if (latitude.isEmpty() || longitude.isEmpty()) return@launch
            data.value.loading = true
            data.value = repository.getWeather(latitude, longitude, "metric")
            if (data.value.data.toString().isNotEmpty()) data.value.loading = false
        }
        Log.d("GET", "getWeather: ${data.value.data.toString()}")
    }

}