package com.example.practice.service.server.model

data class PokemonResponse(
    val pokemonCache: Pokemon?,
    val error: String?
)