package com.example.practice.service.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.practice.service.cache.form.PokemonFormCache
import com.example.practice.service.cache.form.PokemonFormDAO
import com.example.practice.service.cache.pokemon.PokemonCache
import com.example.practice.service.cache.pokemon.PokemonDAO

@Database(
    entities = [
        PokemonCache::class,
        PokemonFormCache::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDAO(): PokemonDAO
    abstract fun pokemonFormDAO(): PokemonFormDAO
}