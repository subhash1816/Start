package com.example.login.model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("error") var error : NoLocation? ,
    @SerializedName("location") var loc : Location? ,
    @SerializedName("current") var current : Current?

)

