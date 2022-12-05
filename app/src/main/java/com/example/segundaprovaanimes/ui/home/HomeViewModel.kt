package com.example.segundaprovaanimes.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.segundaprovaanimes.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(private var repository: AnimeRepository) : ViewModel() {

    var anime = repository.listAll().asLiveData()
}
