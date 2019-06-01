package com.example.pokefull.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


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
    @field:Json(name = "pokemonID")@ColumnInfo(name = "pokemonID") val pokemonId: Int,
    @field:Json(name = "typeID")@ColumnInfo(name = "typeID") val typeId: Int
)
