package com.example.practice.service.server.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("id") val pokemonId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("forms") val forms: ArrayList<PokemonFormLink>,
    @SerializedName("sprites") val sprites: PokemonSprite?
)
