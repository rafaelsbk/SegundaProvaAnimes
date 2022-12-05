package com.example.segundaprovaanimes.ui.altera

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.segundaprovaanimes.R
import com.example.segundaprovaanimes.databinding.FragmentAlteraBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlteraFragment : Fragment() {

    private lateinit var _binding: FragmentAlteraBinding
    private lateinit var _viewmodel: AlteraViewModel

    val args: AlteraFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewmodel = ViewModelProvider(this).get(AlteraViewModel::class.java)
        _binding = FragmentAlteraBinding.inflate(inflater, container, false)

        _binding.viewmodel = _viewmodel
        _binding.lifecycleOwner = this

        Log.i("idFragment", "${args.id}")

        Log.i("idFragment", "${_viewmodel.anime.value}")

        _viewmodel.changeValueId(args.id)

        _viewmodel.postAnimeValue(_viewmodel.initId.value!!)

        Log.i("idFragment" ,"id no viewmodel ${_viewmodel.initId.value}")
//        _viewmodel.initId.observe(viewLifecycleOwner, Observer {
//
//        })

        _binding.buttonAlterar.setOnClickListener{
            _viewmodel.alteraAnime()
            Navigation.findNavController(it).navigate(R.id.navigation_home)
            Toast.makeText(requireContext(), "Sucesso! Seu anime foi alterado", Toast.LENGTH_SHORT).show()
        }

        return _binding.root
    }

}