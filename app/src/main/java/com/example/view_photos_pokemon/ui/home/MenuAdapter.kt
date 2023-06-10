package com.example.view_photos_pokemon.ui.home

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.view_photos_pokemon.R
import com.example.view_photos_pokemon.databinding.ItemMenuBinding
import com.example.view_photos_pokemon.model.Menu
import com.example.view_photos_pokemon.utils.PokemonColorUtil


class MenuAdapter(
    private val list : List<Menu>,
    private val context: Context
    ) : RecyclerView.Adapter<com.example.view_photos_pokemon.ui.home.MenuAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val viewBinding = ItemMenuBinding.bind(itemView)
        fun bindView(item: Menu) {
            viewBinding.textViewName.text = itemView.context.getString(item.name)
            val color = PokemonColorUtil(itemView.context).convertColor(item.color)
            viewBinding.relativeLayoutBackground.background.colorFilter =
                PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)

            itemView.setOnClickListener {
                it.findNavController().navigate(R.id.action_pokedexFragment4_to_pokedexFragment3)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bindView(item)
    }
}