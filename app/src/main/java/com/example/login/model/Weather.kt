package com.example.login.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("location") var loc : Location? = null,
    @SerializedName("current") var current : Current? = null,
    @SerializedName("error") var failure : NoLocation? = null
)

