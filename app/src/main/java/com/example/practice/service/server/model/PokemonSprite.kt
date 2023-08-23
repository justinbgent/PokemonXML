package com.example.practice.service.server.model

import com.google.gson.annotations.SerializedName

data class PokemonSprite(
    @SerializedName("front_default") val frontSpriteUrl: String?
)