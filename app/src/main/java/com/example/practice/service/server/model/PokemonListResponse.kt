package com.example.practice.service.server.model

data class PokemonListResponse(
    val pokemon: PokemonList?,
    val error: String?
)