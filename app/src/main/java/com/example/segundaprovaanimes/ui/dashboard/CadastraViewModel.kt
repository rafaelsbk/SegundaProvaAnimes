package com.example.segundaprovaanimes.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.segundaprovaanimes.model.Anime
import com.example.segundaprovaanimes.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CadastraViewModel @Inject constructor(var repository: AnimeRepository) : ViewModel() {

    var anime = MutableLiveData<Anime>()

    init {
        anime.value = Anime("", 0, "", 0, "","")
    }

    fun cadastrarButtonEvent(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                anime.value?.let { repository.create(it) }
            }
        }
    }
}