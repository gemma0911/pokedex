package com.example.view_photos_pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.view_photos_pokemon.api.ApiInterface
import com.example.view_photos_pokemon.api.ApiUtilities
import com.example.view_photos_pokemon.databinding.ActivityMainBinding
import com.example.view_photos_pokemon.repository.PokemonRepository
import com.example.view_photos_pokemon.viewmodel.PokemonViewModel
import com.example.view_photos_pokemon.viewmodel.PokemonViewModelFactory
import com.google.android.material.navigation.NavigationBarView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(PokemonFragment())
        binding.menu.setOnItemSelectedListener(
            NavigationBarView.OnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.pokemon -> replaceFragment(PokemonFragment())
                }
                true
            })
    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_layout,fragment)
        fragmentTransaction.commit()
    }
}
