package com.example.login

import retrofit2.Call
import retrofit2.http.GET

interface ServiceTwo
{
    @GET("a86df740-3b7b-4213-8874-30d78e37862b")
    fun multilist() : Call<List<MultiViews>>
}