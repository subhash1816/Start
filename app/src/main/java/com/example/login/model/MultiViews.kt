package com.example.login.model

import com.google.gson.annotations.SerializedName

data class MultiViews(
    @SerializedName("View") val layoutView: String?,
    @SerializedName("Name") val name: String?,
    @SerializedName("Mobile") val mobile: String?,
    @SerializedName("Image") val image: String?,
    @SerializedName("Hint") val hint: String?
)
