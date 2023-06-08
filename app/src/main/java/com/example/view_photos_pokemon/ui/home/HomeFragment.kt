package com.example.view_photos_pokemon.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.view_photos_pokemon.R
import com.example.view_photos_pokemon.databinding.FragmentHomeBinding
import com.example.view_photos_pokemon.model.Menu
import com.example.view_photos_pokemon.utils.PokemonColorUtil

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var viewBinding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding = FragmentHomeBinding.bind(view)


        activity?.window?.statusBarColor =
            PokemonColorUtil(view.context).convertColor(R.color.backgroundLight)

        homeViewModel = HomeViewModel()

        viewBinding?.recyclerViewMenu?.layoutManager = GridLayoutManager(context, 2)

        homeViewModel.getListMenu().observe(viewLifecycleOwner) {
            val list : List<Menu> = it
            viewBinding?.recyclerViewMenu?.adapter = MenuAdapter(list,view.context)
        }

    }
}