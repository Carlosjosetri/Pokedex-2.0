package com.example.pokefull.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "pokemon_x_type",
    foreignKeys = [
        ForeignKey(
            entity = Pokemon::class,
            parentColumns = ["id"],
            childColumns = ["pokemonID"]
        ),
        ForeignKey(
            entity = Type::class,
            parentColumns = ["id"],
            childColumns = ["typeID"]
        )],
    primaryKeys = ["pokemonID", "typeID"]
)

data class PokemonXType(
    @ColumnInfo(name = "pokemonID") val pokemonid: Int,
    @ColumnInfo(name = "typeID") val typeid: Int
)
