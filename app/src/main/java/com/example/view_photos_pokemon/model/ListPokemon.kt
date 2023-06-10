package com.example.view_photos_pokemon.model

data class ListPokemon(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)