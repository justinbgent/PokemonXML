package com.example.practice.service.cache.pokemon

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pokemon")
data class PokemonCache(
    @Transient @PrimaryKey @ColumnInfo(name = "pokemonId") @SerializedName("pokemonId") val pokemonId: Int,
    @ColumnInfo(name = "name") @SerializedName("name") val name: String,
    @ColumnInfo(name = "height") @SerializedName("height") val height: Int,
    @ColumnInfo(name = "weight") @SerializedName("weight") val weight: Int
)
