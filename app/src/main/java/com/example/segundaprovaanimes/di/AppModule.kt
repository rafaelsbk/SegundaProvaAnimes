package com.example.segundaprovaanimes.di

import android.app.Application
import com.example.segundaprovaanimes.dao.AnimeDao
import com.example.segundaprovaanimes.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getDatabase(applicationContext: Application): AppDatabase {
        return AppDatabase.invoke(applicationContext)
    }

    @Singleton
    @Provides
    fun getDao(database:AppDatabase): AnimeDao {
        return database.animeDao()
    }

}