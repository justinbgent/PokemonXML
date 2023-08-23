package com.example.practice.service.cache

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        val builder = Room.databaseBuilder(context, AppDatabase::class.java, "pokemon_v1.db")
        return builder.build()
    }

    @Singleton
    @Provides
    fun providePokemonDAO(db: AppDatabase) = db.pokemonDAO()

    @Singleton
    @Provides
    fun providePokemonFormDAO(db: AppDatabase) = db.pokemonFormDAO()

}