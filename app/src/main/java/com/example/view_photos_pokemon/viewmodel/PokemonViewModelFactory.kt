package com.example.view_photos_pokemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.view_photos_pokemon.repository.PokemonRepository

class PokemonViewModelFactory(private val pokemonRepository: PokemonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PokemonViewModel(pokemonRepository) as T
    }
}