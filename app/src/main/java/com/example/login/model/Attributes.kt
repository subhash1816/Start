package com.example.login.model

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("Name") val playerNameApi: String?,
    @SerializedName("Image") val playerImageApi: String?,
    @SerializedName("Special") val playerSpecialApi: String?
)
