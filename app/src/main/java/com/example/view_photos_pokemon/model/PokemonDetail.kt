package com.example.view_photos_pokemon.model

data class PokemonDetail(
    val height: Int,
    val id: Int,
    val name: String,
    val types: List<Type>,
    val weight: Int
)