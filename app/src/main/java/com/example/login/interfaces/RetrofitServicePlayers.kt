package com.example.login.interfaces

import com.example.login.model.Attributes
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitServicePlayers {
    @GET("9e8b6d48-5f08-49c9-ac15-38947bccae0a")
    fun playerlist(): Call<List<Attributes>>

    companion object {
        fun getInstance(): RetrofitServicePlayers {
            return Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitServicePlayers::class.java)
        }
    }
}
