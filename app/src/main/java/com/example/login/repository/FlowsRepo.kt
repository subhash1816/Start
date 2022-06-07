package com.example.login.repository

import com.example.login.interfaces.RetrofitInstanceApi

class FlowsRepo(private var city: String) {

    suspend fun weatherCall() = RetrofitInstanceApi.getWeatherInstance().weatherlist(city).body()

}


