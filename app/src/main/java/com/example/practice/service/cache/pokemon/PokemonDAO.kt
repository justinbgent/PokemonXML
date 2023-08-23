package com.example.practice.service.cache.pokemon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface PokemonDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemonCache: PokemonCache)

    @Update
    fun update(pokemonCache: PokemonCache)

    @Query("SELECT * FROM pokemon WHERE pokemonId=:pokemonId")
    fun get(pokemonId: String): PokemonCache

    @Query("DELETE FROM pokemon")
    fun deleteAll()

    @Query("DELETE FROM pokemon WHERE pokemonId=:pokemonId")
    fun deleteOne(pokemonId: String)
}