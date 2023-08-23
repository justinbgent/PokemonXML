package com.example.practice.service.cache.form

import androidx.room.*

@Dao
interface PokemonFormDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemonFormCache: PokemonFormCache)

    @Update
    fun update(pokemonFormCache: PokemonFormCache)

    @Query("SELECT * FROM pokemonForm WHERE pokemonFormId=:pokemonFormId")
    fun get(pokemonFormId: String): PokemonFormCache

    @Query("DELETE FROM pokemonForm")
    fun deleteAll()

    @Query("DELETE FROM pokemonForm WHERE pokemonFormId=:pokemonFormId")
    fun deleteOne(pokemonFormId: String)
}