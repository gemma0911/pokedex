package com.example.view_photos_pokemon.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokemon.Model.Pokemon
import com.example.view_photos_pokemon.api.ApiInterface

class PokemonRepository(private val apiInterface: ApiInterface)  {

    private val pokemonLiveData = MutableLiveData<Pokemon>()

    val results : LiveData<Pokemon>
        get() = pokemonLiveData
    suspend fun getResults(i : Int) {
        var api = apiInterface.getNamePokemon(i,20)
        if(api.body()!=null) {
            pokemonLiveData.postValue(api.body())
        }
    }
}
