package com.example.pokefull.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "pokemon_table")
data class Pokemon (
    @PrimaryKey @field:Json(name = "id")@ColumnInfo(name = "id") val number: Int,
    @field:Json (name = "name") @ColumnInfo(name = "name") val name: String,
    @field:Json(name = "name")@ColumnInfo(name = "weight") val weight: String
)