package com.example.view_photos_pokemon.model

import androidx.annotation.ColorRes
import androidx.annotation.StringRes

data class Menu(
    val id: Int,
    @StringRes val name: Int,
    @ColorRes val color: Int
)
