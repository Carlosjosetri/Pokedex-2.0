package com.example.pokefull.services.retrofit

import com.example.pokefull.database.entities.Pokemon
import com.example.pokefull.database.entities.Type
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://pokeapi.co/api/v2/"

interface PokemonService {

    @GET("pokemon/{pokename}/")
    fun getPokemon(@Path("pokename") pokename: String): Deferred<Response<List<Pokemon>>>

    @GET("pokemon/?offset={offset}&limit={limit}/")
    fun getPokemons(
        @Path("pokename") pokename: String,
        @Path("offset") offset: String,
        @Path("limit") limit: String
    ): Deferred<Response<List<Pokemon>>>

    @GET("type")
    fun getTypes(): Deferred<Response<List<Type>>>


    companion object {

        fun getPokemonService(): PokemonService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(PokemonService::class.java)
        }
    }

}