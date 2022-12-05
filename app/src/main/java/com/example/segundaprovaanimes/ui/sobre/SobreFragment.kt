package com.example.segundaprovaanimes.ui.sobre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.segundaprovaanimes.databinding.FragmentSobreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SobreFragment : Fragment(){

    private lateinit var _binding: FragmentSobreBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSobreBinding.inflate(inflater, container, false)

        _binding.lifecycleOwner = this

        return _binding.root
    }
}