package com.example.practice.service.server.model

import com.google.gson.annotations.SerializedName

data class PokemonList(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: ArrayList<Pokemon>
)
