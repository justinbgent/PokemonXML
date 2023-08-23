package com.example.practice.service.server

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private var serverClient: Retrofit? = null

    fun serverClient(): Retrofit? {
        if (serverClient == null) {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
            val server = "https://pokeapi.co/api/v2/"
            serverClient = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
                .baseUrl(server)
                .client(okHttpClient)
                .build()
        }
        return serverClient
    }
}