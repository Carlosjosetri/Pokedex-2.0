package com.example.pokefull.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokefull.database.entities.Type

@Dao
interface TypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertType(type: Type)

    @Query("SELECT * FROM TYPE_TABLE")
    fun getTypes(): LiveData<List<Type>>

    @Query("SELECT * FROM TYPE_TABLE WHERE name=:nameType")
    fun getType(nameType: String): LiveData<List<Type>>

    @Query("SELECT * FROM TYPE_TABLE WHERE name=:IDType")
    fun getType(IDType: Int): LiveData<List<Type>>
}