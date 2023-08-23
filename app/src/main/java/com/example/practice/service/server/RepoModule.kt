package com.example.practice.service.server

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {
    @Provides
    fun providePokemonRepository(): PokemonRepository = PokemonRepository()
}