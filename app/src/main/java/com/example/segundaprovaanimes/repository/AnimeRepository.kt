package com.example.segundaprovaanimes.repository

import androidx.lifecycle.LiveData
import com.example.segundaprovaanimes.dao.AnimeDao
import com.example.segundaprovaanimes.model.Anime
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeRepository @Inject constructor(private var dao: AnimeDao) : IAnimeRepository {

    override fun listAll(): Flow<List<Anime>> {
        return dao.listAll()
    }

    override fun create(a: Anime) {
        dao.create(a)
    }

    override suspend fun findById(id:Long): Anime {
        return dao.findById(id)
    }

    override fun update(a: Anime) {
        return dao.update(a)
    }


}