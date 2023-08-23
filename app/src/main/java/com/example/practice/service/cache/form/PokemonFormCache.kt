package com.example.practice.service.cache.form

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pokemonForm")
data class PokemonFormCache(
    @Transient @PrimaryKey @ColumnInfo(name = "pokemonFormId") @SerializedName("pokemonFormId") val pokemonFormId: Int,
    @Transient @ColumnInfo(name = "pokemonId") @SerializedName("pokemonId") val pokemonId: Int,
    @ColumnInfo(name = "name") @SerializedName("name") val name: String,
    @ColumnInfo(name = "baseForm") @SerializedName("is_default") val baseForm: Boolean,
    @ColumnInfo(name = "formNumber") @SerializedName("form_order") val formNumber: Int,
    @ColumnInfo(name = "sprite") @SerializedName("sprite") val sprite: String?
)
