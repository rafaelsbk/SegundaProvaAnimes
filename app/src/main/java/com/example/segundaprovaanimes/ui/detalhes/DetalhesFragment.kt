package com.example.segundaprovaanimes.ui.detalhes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.segundaprovaanimes.databinding.FragmentDetalhesBinding
import com.example.segundaprovaanimes.ui.altera.AlteraFragmentArgs
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetalhesFragment : Fragment() {

    private lateinit var _binding: FragmentDetalhesBinding
    private lateinit var _viewmodel: DetalhesViewModel

    val args: AlteraFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalhesBinding.inflate(inflater, container, false)
        _viewmodel = ViewModelProvider(this)[DetalhesViewModel::class.java]

        _binding.viewmodel = _viewmodel
        _binding.lifecycleOwner = this

        _viewmodel.changeValueId(args.id)

        _viewmodel.postAnimeValue(_viewmodel.initId.value!!)
       // var id = arguments?.getInt("position")
       // _viewmodel.animeSelecionado(id!!)
        return _binding.root
    }
}