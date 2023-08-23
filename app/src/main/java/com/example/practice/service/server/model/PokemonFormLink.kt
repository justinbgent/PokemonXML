package com.example.practice.service.server.model

import com.google.gson.annotations.SerializedName

data class PokemonFormLink(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
