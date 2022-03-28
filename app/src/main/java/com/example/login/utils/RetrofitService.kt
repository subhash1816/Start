package com.example.login.utils

import com.example.login.model.Attributes
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("9e8b6d48-5f08-49c9-ac15-38947bccae0a")
    fun playerlist(): Call<List<Attributes>>
}
