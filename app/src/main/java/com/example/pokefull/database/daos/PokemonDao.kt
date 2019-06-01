package com.example.pokefull.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pokefull.database.entities.Pokemon

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: Pokemon)

    @Query("SELECT * FROM POKEMON_TABLE")
    fun getAllPokemons(): LiveData<List<Pokemon>>

    @Query("SELECT * FROM POKEMON_TABLE WHERE id = :id")
    fun getPokemon(id: Int): LiveData<List<Pokemon>>


    @Query("SELECT * FROM POKEMON_TABLE WHERE name = :name")
    fun getPokemon(name: String): LiveData<List<Pokemon>>

    @Delete
    suspend fun delete()
}