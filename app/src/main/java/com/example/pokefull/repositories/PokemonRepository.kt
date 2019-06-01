package com.example.pokefull.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.pokefull.database.daos.PokemonDao
import com.example.pokefull.database.daos.PokemonXTypeDao
import com.example.pokefull.database.daos.TypeDao
import com.example.pokefull.database.entities.Pokemon
import com.example.pokefull.database.entities.PokemonXType
import com.example.pokefull.database.entities.Type
import com.example.pokefull.services.retrofit.PokemonService
import kotlinx.coroutines.Deferred
import retrofit2.Response


class PokemonRepository(
    private val pokemonDao: PokemonDao, private val typeDao: TypeDao,
    private val pxtDao: PokemonXTypeDao
) {
    var pokelist: LiveData<List<Pokemon>> = pokemonDao.getAllPokemons()
    var typelist: LiveData<List<Type>> = typeDao.getTypes()

//    fun RetrievePokemonAsync(pokename: String): Deferred<Response<List<Pokemon>>> {
//        return PokemonService.getPokemonService().getPokemon(pokename)
//    }



    @WorkerThread
    suspend fun insertPokemon(pokemon: Pokemon) {
        pokemonDao.insertPokemon(pokemon)
    }

    @WorkerThread
    suspend fun insertType(type: Type) {
        typeDao.InsertType(type)
    }

    @WorkerThread
    fun FindPokemon(IdPokemon: Int) {
        pokemonDao.getPokemon(IdPokemon)
    }

    @WorkerThread
    fun FindPokemon(NamePokemon: String) {
        pokemonDao.getPokemon(NamePokemon)
    }

    @WorkerThread
    suspend fun insertpxt(pokemonXType: PokemonXType) {
        pxtDao.InsertPXT(pokemonXType)
    }

    @WorkerThread
    fun FindPokemonbyType(typeid: Int) {
        pxtDao.getPokemon(typeid)

    }

    @WorkerThread
    fun FindTypebyPokemon(pokemonid: Int) {
        pxtDao.getPokemon(pokemonid)

    }
    @WorkerThread
    suspend fun deletepokemon(){
        pokemonDao.delete()
    }

}