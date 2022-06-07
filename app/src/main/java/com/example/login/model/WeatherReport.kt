package com.example.login.model

import com.google.gson.annotations.SerializedName

data class WeatherReport(
    @SerializedName("error") var error : NoLocation? = null,
    var weather : Weather? = null

)
