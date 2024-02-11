package com.kumuda.jetweatherforecast.data

class DataOrException<T, Boolean, E: Exception> (
    val data: T? = null,
    var loading: Boolean? = null,
    val e: E? = null
){

}