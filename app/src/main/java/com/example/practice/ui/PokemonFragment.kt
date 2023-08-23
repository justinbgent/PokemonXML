package com.example.practice.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.FragmentPokemonBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonFragment: Fragment() {

    companion object {
        fun instance(): PokemonFragment {
            return PokemonFragment()
        }
    }

    private lateinit var binding: FragmentPokemonBinding
    private val viewModel: PokemonViewModel by viewModels()
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding =
            FragmentPokemonBinding.inflate(layoutInflater, container, false)

        initRecycler()
        viewModel.pokemonData.observe(viewLifecycleOwner) { pokemonList ->
            pokemonAdapter.list = pokemonList
            pokemonAdapter.notifyDataSetChanged()
        }
        viewModel.getPokemon(0)

        return binding.root
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = RecyclerView.VERTICAL
        binding.recyclerView.layoutManager = layoutManager

        pokemonAdapter = PokemonAdapter()
        binding.recyclerView.adapter = pokemonAdapter
    }

}