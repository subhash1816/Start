package com.example.login.model

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("temp_c") val temp : String?
)
