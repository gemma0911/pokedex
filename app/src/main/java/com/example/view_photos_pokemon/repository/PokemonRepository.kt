package com.example.view_photos_pokemon.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokemon.Model.Pokemon
import com.example.view_photos_pokemon.api.ApiInterface

class PokemonRepository(private val apiInterface: ApiInterface )  {

    private val pokemonLiveData = MutableLiveData<Pokemon>()

    val results : LiveData<Pokemon>
        get() = pokemonLiveData
    suspend fun getResults() {
        var api = apiInterface.getData()
        if(api.body()!=null) {
            pokemonLiveData.postValue(api.body())
        }
    }
}
