package com.kumuda.jetweatherforecast.model.geolocation

data class GeolocationItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)