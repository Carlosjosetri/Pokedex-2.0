package com.example.pokefull.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pokefull.database.PokemonRoomDatabase
import com.example.pokefull.database.entities.Pokemon
import com.example.pokefull.database.entities.Type
import com.example.pokefull.repositories.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PokemonViewModel(private val app: Application) : AndroidViewModel(app) {

    private val pokeviewrepo: PokemonRepository

    init {
        val pokedao = PokemonRoomDatabase.getInstance(app).pokeDao()
        val typedao = PokemonRoomDatabase.getInstance(app).typeDao()
        val pxtdao = PokemonRoomDatabase.getInstance(app).pxtDao()
        pokeviewrepo = PokemonRepository(pokedao, typedao, pxtdao)
    }

//    fun retrievePokemon(name: String) = viewModelScope.launch {
//
//        // borrar tabla
//        this@PokemonViewModel.delete()
//
//        // obtener respuesta de la API
//
//        val response = pokeviewrepo.RetrievePokemonAsync(name).await()
//
//        if (response.isSuccessful) with(response) {
//            this.body()?.forEach {
//                this@PokemonViewModel.insert(it)
//            }
//        } else with(response) {
//            if (this.code() == 404) Toast.makeText(app, "Pokemon no encontrado", Toast.LENGTH_LONG).show()
//        }
//    }

    private suspend fun delete() = pokeviewrepo.deletepokemon()

    fun getallPokemons(): LiveData<List<Pokemon>> {
        return pokeviewrepo.pokelist
    }

    fun getallTypes(): LiveData<List<Type>> {
        return pokeviewrepo.typelist
    }

    fun insert(pokemon: Pokemon) = viewModelScope.launch(Dispatchers.IO) {
        pokeviewrepo.insertPokemon(pokemon)
    }

    fun insertType(type: Type) = viewModelScope.launch(Dispatchers.IO) {
        pokeviewrepo.insertType(type)
    }

    fun getpokemon(pokename: String) {
        return pokeviewrepo.FindPokemon(pokename)
    }

    fun getpokemon(idpokemon: Int) {
        return pokeviewrepo.FindPokemon(idpokemon)
    }
}