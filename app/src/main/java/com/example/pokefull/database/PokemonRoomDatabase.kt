package com.example.pokefull.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.example.pokefull.database.daos.PokemonDao
import com.example.pokefull.database.daos.PokemonXTypeDao
import com.example.pokefull.database.daos.TypeDao
import com.example.pokefull.database.entities.Pokemon
import com.example.pokefull.database.entities.PokemonXType
import com.example.pokefull.database.entities.Type


@Database(entities = [Pokemon::class, Type::class,PokemonXType::class], version = 1, exportSchema = false)
public abstract class PokemonRoomDatabase : RoomDatabase() {

    abstract fun pokeDao(): PokemonDao
    abstract fun typeDao(): TypeDao
    abstract fun pxtDao(): PokemonXTypeDao

    companion object {

        @Volatile
        private var INSTANCE: PokemonRoomDatabase? = null


        fun getInstance(
            context: Context
        ): PokemonRoomDatabase {

            val temp = INSTANCE

            if (temp != null) return temp
            else synchronized(this) {
                val instance =
                    Room
                        .databaseBuilder(
                            context,
                            PokemonRoomDatabase::class.java,
                            "Pokemon_Database"
                        )
                        .build()

                INSTANCE = instance

                return instance
            }

        }


    }
}