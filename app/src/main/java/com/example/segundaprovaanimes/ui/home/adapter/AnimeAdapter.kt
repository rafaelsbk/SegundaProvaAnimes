package com.example.segundaprovaanimes.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.segundaprovaanimes.databinding.AnimeCardBinding
import com.example.segundaprovaanimes.model.Anime


class AnimeAdapter : ListAdapter<Anime, AnimeAdapter.AnimeViewHolder>(AnimeDiffUtilCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = getItem(position)
        holder.bind(anime)
    }

    override fun getItemId(position: Int): Long {
        var id = currentList[position].id
        //Log.i("idList", "$id")

        return id

    }

    class AnimeViewHolder private constructor(var binding: AnimeCardBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(anime: Anime) {
            binding.textViewNomeAnime.text = anime.name
            binding.textViewAnoAnime.text = anime.anoLan
            binding.textViewGeneroAnime.text = anime.genero
            binding.textViewOndeAssAnime.text = anime.ondeAss
            binding.textViewNomeAnime.setOnClickListener {
                Toast.makeText(binding.root.context, "CLicou no texto", Toast.LENGTH_SHORT).show()
            }
        }

        companion object {
            fun from(parent: ViewGroup): AnimeViewHolder {

                val inflater = LayoutInflater.from(parent.context)
                val binding = AnimeCardBinding.inflate(inflater, parent, false)
                return AnimeViewHolder(binding)
            }
        }
    }

    class AnimeDiffUtilCallback : DiffUtil.ItemCallback<Anime>(){
        override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem.id.equals(newItem.id)
        }

        override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem.equals(newItem)
        }

    }
}