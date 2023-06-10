package com.example.view_photos_pokemon.api

import com.example.view_photos_pokemon.model.ListPokemon
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("pokemon")
    suspend fun getPokemon() : Response<ListPokemon>

}