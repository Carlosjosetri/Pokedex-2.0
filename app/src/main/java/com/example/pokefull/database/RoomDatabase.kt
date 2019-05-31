package com.example.pokefull.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import com.example.pokefull.database.daos.PokemonDao
import com.example.pokefull.database.daos.TypeDao
import com.example.pokefull.database.entities.Pokemon
import com.example.pokefull.database.entities.Type


@Database(entities = [Pokemon::class, Type::class], version = 1, exportSchema = false)
public abstract class RoomDatabase : RoomDatabase() {

    abstract fun pokedao(): PokemonDao
    abstract fun typedao(): TypeDao

    companion object {

        @Volatile
        private var INSTANCE: RoomDatabase? = null


        fun getinstance(
            context: Context
        ): RoomDatabase {

            val temp = INSTANCE

            if (temp != null) return temp
            else synchronized(this) {
                val instance =
                    Room
                        .databaseBuilder(
                            context,
                            RoomDatabase::class.java,
                            "Pokemon_Database"
                        )
                        .build()

                INSTANCE = instance

                return instance
            }

        }


    }
}