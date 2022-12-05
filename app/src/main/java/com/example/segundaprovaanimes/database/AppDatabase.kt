package com.example.segundaprovaanimes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.segundaprovaanimes.dao.AnimeDao
import com.example.segundaprovaanimes.model.Anime

@Database(entities = [Anime::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun animeDao(): AnimeDao

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "anime_database.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}