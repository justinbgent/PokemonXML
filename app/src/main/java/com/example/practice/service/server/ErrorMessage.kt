package com.example.practice.service.server

import com.google.gson.annotations.SerializedName

data class ErrorMessage(
    @SerializedName("code") val code: String?,
    @SerializedName("message") val message: String?,
    @SerializedName("timestamp") val timestamp: String?
)