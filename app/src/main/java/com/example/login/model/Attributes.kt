package com.example.login.model

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("Name") val playerNameApi: String?,
    @SerializedName("Image") val playerImageApi: String?,
    @SerializedName("Special") val playerSpecialApi: String?
)

data class MultiViews(
    @SerializedName("View") val layoutView: String?,
    @SerializedName("Name") val name: String?,
    @SerializedName("Mobile") val mobile: String?,
    @SerializedName("Image") val image: String?,
    @SerializedName("Hint") val hint: String?
)
