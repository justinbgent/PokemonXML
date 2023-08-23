package com.example.practice.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice.service.server.PokemonRepository
import com.example.practice.service.server.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private val scopeIO = CoroutineScope(Dispatchers.IO)

    val pokemonData = MutableLiveData<ArrayList<Pokemon>>()

    fun getPokemon(offset: Int) {
        scopeIO.launch {
            val data = repository.getPokemonList(offset)

            if (data.pokemon != null) {
                viewModelScope.launch {
                    pokemonData.value = data.pokemon.results
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        scopeIO.cancel()
    }
}