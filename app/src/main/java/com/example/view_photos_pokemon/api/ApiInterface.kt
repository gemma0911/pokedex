package com.example.view_photos_pokemon.api

import com.example.pokemon.Model.Pokemon
import com.example.view_photos_pokemon.model.PokemonDetail
import com.example.view_photos_pokemon.model.Results
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("pokemon")
    suspend fun getData() : Response<Results>

//    @GET("pokemon/{name}")
//    fun getPokemon(@Path("name") name: String) : Call<PokemonDetail>

}