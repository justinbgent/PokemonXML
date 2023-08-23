package com.example.practice.service.server

import com.example.practice.service.server.model.Pokemon
import com.example.practice.service.server.model.PokemonList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface IPokemonService {

    @Headers("Content-Type: application/json")
    @GET("pokemon/{nameOrId}")
    suspend fun getPokemon(@Path("nameOrId") nameOrId: String): Response<Pokemon>

    /***
     * Note that this API call and data can be reused for other endpoints with the API.
     * Only the type of data the array list inside PokemonList has will need to change.
     */
    @GET("pokemon")
    suspend fun getPokemonList(
//        @Header("Authorization") token: String, <- If there was a bearer auth token header needed.
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): Response<PokemonList>
}