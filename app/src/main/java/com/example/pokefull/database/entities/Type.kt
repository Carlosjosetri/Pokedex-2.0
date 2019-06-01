package com.example.pokefull.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "type_table")
data class Type (
    @PrimaryKey @field:Json(name = "id")@ColumnInfo(name = "id") val id: Int,
    @field:Json (name = "name") @ColumnInfo(name = "name") val name: String

)