package com.example.segundaprovaanimes.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.segundaprovaanimes.model.Anime
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {
    @Query("SELECT * FROM anime")
    fun listAll(): Flow<List<Anime>>
    ///////////////////////////////////////
    @Query("SELECT * FROM anime where id=:id")
    fun findById(id:Long): Anime
    //////////////////////////////////////
    @Delete
    fun deletarVarios(a: Anime)
    //////////////////////////////////////
    @Query("DELETE FROM anime where id=:id")
    fun deleteId(id: Long)
    /////////////////////////////////////
    @Update
    fun update(a:Anime)
    //////////////////////////////////////
    @Insert
    fun create(a:Anime)
}