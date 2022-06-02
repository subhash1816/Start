package com.example.login.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("location") val loc : Location?,
    @SerializedName("current") val current : Current?
)

