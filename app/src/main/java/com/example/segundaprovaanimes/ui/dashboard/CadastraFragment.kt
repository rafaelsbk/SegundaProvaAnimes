package com.example.segundaprovaanimes.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.segundaprovaanimes.R
import com.example.segundaprovaanimes.databinding.FragmentCadastraBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CadastraFragment : Fragment() {

    private lateinit var _binding: FragmentCadastraBinding
    private lateinit var _viewmodel: CadastraViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewmodel = ViewModelProvider(this).get(CadastraViewModel::class.java)
        _binding = FragmentCadastraBinding.inflate(inflater, container, false)

        _binding.viewmodel = _viewmodel
        _binding.lifecycleOwner = this

        _binding.buttonCadastrar.setOnClickListener{
            _viewmodel.cadastrarButtonEvent()
            Navigation.findNavController(it).navigate(R.id.navigation_home)
            Toast.makeText(requireContext(), "Sucesso! Seu anime foi cadastrado", Toast.LENGTH_SHORT).show()
        }

        return _binding.root
    }
}