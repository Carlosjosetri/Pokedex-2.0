package com.example.pokefull.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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
}