package com.example.view_photos_pokemon.api

import android.graphics.ColorSpace.Model
import com.example.pokemon.Model.Pokemon
import com.example.view_photos_pokemon.model.PokemonDetail
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {
    @GET("pokemon/")
    suspend fun getNamePokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ) : Response<Pokemon>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String) : Call<PokemonDetail>

}