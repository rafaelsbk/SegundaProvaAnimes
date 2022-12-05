package com.example.segundaprovaanimes.ui.detalhes


import androidx.lifecycle.*
import com.example.segundaprovaanimes.model.Anime
import com.example.segundaprovaanimes.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetalhesViewModel @Inject constructor(private var repository: AnimeRepository) : ViewModel() {
    private var _anime = MutableLiveData<Anime>()
    val anime : LiveData<Anime>
        get() = _anime

    private var _initId = MutableLiveData<Long>()
    val initId : LiveData<Long>
        get() = _initId

//    fun animeSelecionado(id: Int){
//        viewModelScope.launch {
//            withContext(Dispatchers.IO){
//                id.let {
//                   // anime = repository.findById(it+1.toLong())
//                }
//            }
//        }
//    }

    fun postAnimeValue(id : Long){
        viewModelScope.launch(Dispatchers.IO){
            _anime.postValue(repository.findById(id))
        }
    }
    fun changeValueId(id: Long){
        _initId.value = id
    }
}