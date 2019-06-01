package com.example.pokefull.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokefull.database.entities.Pokemon
import com.example.pokefull.database.entities.PokemonXType
import com.example.pokefull.database.entities.Type

@Dao
interface PokemonXTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertPXT(pxt: PokemonXType)

    @Query("SELECT * FROM pokemon_table INNER JOIN pokemon_x_type ON id=pokemonID WHERE id=:IDPokemon")
    fun getPokemon(IDPokemon: Int): LiveData<List<Pokemon>>

    @Query("SELECT * FROM type_table INNER JOIN pokemon_x_type ON id=typeID  WHERE id=:IDType")
    fun getType(IDType: Int): LiveData<List<Type>>

}