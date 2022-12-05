package com.example.segundaprovaanimes.repository

import androidx.lifecycle.LiveData
import com.example.segundaprovaanimes.model.Anime
import kotlinx.coroutines.flow.Flow

interface IAnimeRepository {
    fun listAll(): Flow<List<Anime>>
    fun create(a: Anime)
    suspend fun findById(id:Long) : Anime
    fun update(a: Anime)
}