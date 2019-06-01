package com.example.pokefull.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.pokefull.database.PokemonRoomDatabase
import com.example.pokefull.repositories.PokemonRepository


class PokemonViewModel(app: Application) : AndroidViewModel(app) {

    private val pokeviewrepo: PokemonRepository

    init {
        val pokedao = PokemonRoomDatabase.getInstance(app).pokeDao()
        val typedao = PokemonRoomDatabase.getInstance(app).typeDao()
        val pxtdao = PokemonRoomDatabase.getInstance(app).pxtDao()
        pokeviewrepo = PokemonRepository()
    }
    


}