package com.example.practice.service.server.model

import com.google.gson.annotations.SerializedName

data class PokemonForm(
    @SerializedName("id") val pokemonFormId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("is_default") val baseForm: Boolean,
    @SerializedName("form_order") val formNumber: Int,
    @SerializedName("sprites") val sprites: PokemonSprite
)
