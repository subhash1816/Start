package com.example.login.utils

import com.example.login.model.Attributes
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("2ac06927-00d9-41ad-a5ef-5ccfdd26d21b")
    fun playerlist(): Call<List<Attributes>>
}
