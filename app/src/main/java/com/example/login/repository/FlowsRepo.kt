package com.example.login.repository

import android.util.Log
import com.example.login.interfaces.RetrofitInstanceApi
import com.example.login.model.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class FlowsRepo(private var city: String) {


    fun countDownFlow(): Flow<Weather> = flow {
        val response = RetrofitInstanceApi.getWeatherInstance().weatherlist(city).body()!!
    //    Log.d("response", response.toString())
        emit(response)

    }.flowOn(Dispatchers.IO)
    // .conflate()

}