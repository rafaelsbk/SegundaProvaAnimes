package com.example.segundaprovaanimes.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.segundaprovaanimes.R
import com.example.segundaprovaanimes.databinding.FragmentHomeBinding
import com.example.segundaprovaanimes.ui.home.adapter.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private lateinit var _viewmodel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewmodel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        _binding.viewmodel = _viewmodel
        _binding.lifecycleOwner = this

        val adapter = AnimeAdapter()

        _viewmodel.anime.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        _binding.recyclerview.adapter = adapter

        _binding.recyclerview.addOnItemTouchListener(
            RecyclerView(_binding.recyclerview, object : RecyclerView.OnItemClickListener{
                override fun onItemClick(view: View, position: Int) {
                    //var bundle = Bundle();
                    //Navigation.findNavController(view).navigate(R.id.navigation_notifications, bundle)
                    Navigation.findNavController(_binding.recyclerview).navigate(HomeFragmentDirections.actionNavigationHomeToNavigationNotifications(adapter.getItemId(position)))

                    Toast.makeText(requireContext(), "Toque simples", Toast.LENGTH_SHORT).show()
                }

                override fun onItemLongClick(view: View, position: Int) {
                    //var bundle = Bundle();
                    Navigation.findNavController(_binding.recyclerview).navigate(HomeFragmentDirections.actionNavigationHomeToNavigationAltera2(adapter.getItemId(position)))

                    //Navigation.findNavController(view).navigate(R.id.navigation_altera, bundle)
                   // Navigation.findNavController(_binding.recyclerview).navigate(HomeFragmentDirections.actionNavigationHomeToNavigationAltera2(adapter.getItemId(position)))

                    Toast.makeText(requireContext(), "Toque longo", Toast.LENGTH_SHORT).show()
                }

            }))

        return _binding.root
    }
}