package com.example.view_photos_pokemon

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.view_photos_pokemon.model.PokemonDetail
import com.squareup.picasso.Picasso


class PokemonAdapter(private var pokemonList: ArrayList<PokemonDetail>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                val view : View = LayoutInflater.from(context).inflate(R.layout.pokemon_grass,parent,false)
                Grass(view)
            }
            2 -> {
                val view : View = LayoutInflater.from(context).inflate(R.layout.pokemon_fire,parent,false)
                Fire(view)
            }
            3 -> {
                val view : View = LayoutInflater.from(context).inflate(R.layout.pokemon_water,parent,false)
                Fire(view)
            }
            4 -> {
                val view : View = LayoutInflater.from(context).inflate(R.layout.pokemon_dragon,parent,false)
                Fire(view)
            }
            5 -> {
                val view : View = LayoutInflater.from(context).inflate(R.layout.pokemon_ghost,parent,false)
                Fire(view)
            }
            6 -> {
                val view : View = LayoutInflater.from(context).inflate(R.layout.pokemon_flying,parent,false)
                Fire(view)
            }
            7 -> {
                val view : View = LayoutInflater.from(context).inflate(R.layout.pokemon_fighting,parent,false)
                Fire(view)
            }
            8 -> {
                val view : View = LayoutInflater.from(context).inflate(R.layout.pokemon_electric,parent,false)
                Fire(view)
            }
            9 -> {
                val view : View = LayoutInflater.from(context).inflate(R.layout.pokemon_fairy,parent,false)
                Fire(view)
            }
            else -> {
                val view : View = LayoutInflater.from(context).inflate(R.layout.pokemon_grass,parent,false)
                Grass(view)
            }
        }
    }

    fun setFilteredList(): ArrayList<PokemonDetail> {
        this.pokemonList = pokemonList
        return pokemonList
    }

    class Grass(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Fire(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Normal(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Fighting(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Water(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Electric(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Ghost(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Dragon(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Fairy(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Dark(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Rock(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Poison(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Bug(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Steel(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }
    class Ice(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val id = itemView.findViewById<TextView>(R.id.id)
        val type = itemView.findViewById<TextView>(R.id.type)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = pokemonList[position]
        if(holder.javaClass == Grass::class.java) {
            var viewHolder = holder as Grass
            holder.textView.text = item.name
            val image = holder.imageView
            holder.type.text = item.types[0].type.name
            holder.id.text = "#" + item.id
            Log.d("---","${item.id}")
            Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${item.id}.png")
                .fit()
                .into(image)
        } else if(holder.javaClass == Fire::class.java) {
            var viewHolder = holder as Fire
            holder.textView.text = item.name
            val image = holder.imageView
            holder.type.text = item.types[0].type.name
            holder.id.text = "#" + item.id
            Log.d("---","${item.id}")
            Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${item.id}.png")
                .fit()
                .into(image)
        } else if(holder.javaClass == Water::class.java) {
            var viewHolder = holder as Water
            holder.textView.text = item.name
            val image = holder.imageView
            holder.type.text = item.types[0].type.name
            holder.id.text = "#" + item.id
            Log.d("---","${item.id}")
            Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${item.id}.png")
                .fit()
                .into(image)
        } else if(holder.javaClass == Rock::class.java) {
            var viewHolder = holder as Rock
            holder.textView.text = item.name
            val image = holder.imageView
            holder.type.text = item.types[0].type.name
            holder.id.text = "#" + item.id
            Log.d("---","${item.id}")
            Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${item.id}.png")
                .fit()
                .into(image)
        } else if(holder.javaClass == Dragon::class.java) {
            var viewHolder = holder as Dragon
            holder.textView.text = item.name
            val image = holder.imageView
            holder.type.text = item.types[0].type.name
            holder.id.text = "#" + item.id
            Log.d("---","${item.id}")
            Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${item.id}.png")
                .fit()
                .into(image)
        } else if(holder.javaClass == Ice::class.java) {
            var viewHolder = holder as Ice
            holder.textView.text = item.name
            val image = holder.imageView
            holder.type.text = item.types[0].type.name
            holder.id.text = "#" + item.id
            Log.d("---","${item.id}")
            Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${item.id}.png")
                .fit()
                .into(image)
        }else {
            var viewHolder = holder as Grass
            holder.textView.text = item.name
            val image = holder.imageView
            holder.type.text = item.types[0].type.name
            holder.id.text = "#" + item.id
            Log.d("---","${item.id}")
            Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${item.id}.png")
                .fit()
                .into(image)
        }
    }
    override fun getItemCount(): Int {
        return pokemonList.size
    }
    override fun getItemViewType(position: Int): Int {
        var current = pokemonList[position]
        return when (current.types[0].type.name) {
            "grass" -> {
                1
            }
            "fire" -> {
                2
            }
            "water" -> {
                3
            }
            "dragon" -> {
                4
            }
            "ghost" -> {
                5
            }
            "flying" -> {
                6
            }
            "fighting" -> {
                7
            }
            "electric" -> {
                8
            }
            "fairy" -> {
                9
            }
            else -> {
                1
            }

        }
    }
    fun updateUserList(userList: ArrayList<PokemonDetail>){
        this.pokemonList.addAll(userList)
        notifyDataSetChanged()
    }
}