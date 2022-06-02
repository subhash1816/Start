package com.example.login.interfaces

import com.example.login.model.Attributes
import com.example.login.model.MultiViews
import com.example.login.model.Weather
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInstanceApi {

    @GET("9e8b6d48-5f08-49c9-ac15-38947bccae0a")
    suspend fun playerlist(): Response<List<Attributes>>

    @GET("a86df740-3b7b-4213-8874-30d78e37862b")
    suspend fun multilist(): Response<List<MultiViews>>

    @GET("forecast.json?key=44f7310b590145a598a104214220106&days=1&aqi=no&alerts=no")
    suspend fun weatherlist(@Query("q")place : String?) : Response<Weather>

    companion object {
        fun getInstance(): RetrofitInstanceApi {
            return Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitInstanceApi::class.java)
        }

        fun getWeatherInstance(): RetrofitInstanceApi{
            return Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitInstanceApi::class.java)
        }
  }

}


