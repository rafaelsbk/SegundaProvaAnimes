package com.example.segundaprovaanimes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Anime(
    var name:String,
    var qntEp:Int,
    var genero:String,
    var classificacao:Int,
    var ondeAss:String,
    var anoLan:String) {

    @PrimaryKey(autoGenerate = true)
        var id:Long = 0
}