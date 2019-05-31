package com.example.pokefull.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
data class Pokemon (
    @PrimaryKey @ColumnInfo(name = "id") val number: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "weight") val weight: String
)