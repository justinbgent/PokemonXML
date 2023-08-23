package com.example.practice.service.server

import com.example.practice.service.server.model.PokemonListResponse
import com.example.practice.service.server.model.PokemonResponse
import com.google.gson.Gson
import javax.inject.Singleton

class PokemonRepository: BaseRepository() {

    private var service: IPokemonService =
        RetrofitClient.serverClient()?.create(IPokemonService::class.java)!!

    suspend fun getPokemon(nameOrId: String): PokemonResponse {
        /// Could check for internet connection first

        val response = safeApiCall {
            service.getPokemon("0")
        }
        val code = response?.code()
        return if (code != null) {
            when (code) {
                200 -> {
                    try {
                        PokemonResponse(response.body(), null)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        val error = "Data parsing error."
                        PokemonResponse(null, "$error ${e.localizedMessage}")
                    }
                }
                else -> {
                    val error =
                        Gson().fromJson(response.errorBody()?.charStream(), ErrorMessage::class.java)
                    PokemonResponse(null, "Error code:${error.code} ${error.message}")
                }
            }
        }
        else {
            PokemonResponse(null, "Server response error. Unknown")
        }
    }

    suspend fun getPokemonList(offset: Int): PokemonListResponse {
        /// Could check for internet connection first

        val response = safeApiCall {
            service.getPokemonList(offset = offset)
        }
        val code = response?.code()
        return if (code != null) {
            when (code) {
                200 -> {
                    try {
                        PokemonListResponse(response.body(), null)
                    } catch (e: Exception) {
                        e.printStackTrace()
                        val error = "Data parsing error."
                        PokemonListResponse(null, "$error ${e.localizedMessage}")
                    }
                }
                else -> {
                    val error =
                        Gson().fromJson(response.errorBody()?.charStream(), ErrorMessage::class.java)
                    PokemonListResponse(null, "Error code:${error.code} ${error.message}")
                }
            }
        }
        else {
            PokemonListResponse(null, "Server response error. Unknown")
        }
    }

}