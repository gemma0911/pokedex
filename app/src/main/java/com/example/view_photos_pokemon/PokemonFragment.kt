package com.example.view_photos_pokemon

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.Model.Pokemon
import com.example.view_photos_pokemon.api.ApiInterface
import com.example.view_photos_pokemon.api.ApiUtilities
import com.example.view_photos_pokemon.model.PokemonDetail
import com.example.view_photos_pokemon.model.Results
import com.example.view_photos_pokemon.repository.PokemonRepository
import com.example.view_photos_pokemon.viewmodel.PokemonViewModel
import com.example.view_photos_pokemon.viewmodel.PokemonViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PokemonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokemonFragment : Fragment() {

    private lateinit var data: ArrayList<Results>
    private lateinit var pokemonViewModel: PokemonViewModel
    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var recycleView : RecyclerView
    private lateinit var listData : ArrayList<PokemonDetail>
    private var PAGE : Int = 0
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PokemonFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PokemonFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = ArrayList()
        recycleView = view.findViewById(R.id.recycleView)
        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val pokemonRepository = PokemonRepository(apiInterface)
        pokemonViewModel = ViewModelProvider(this, PokemonViewModelFactory(pokemonRepository,PAGE))[PokemonViewModel::class.java]
        pokemonViewModel.pokemon.observe(this@PokemonFragment) {
            data = it.results as ArrayList<Results>
            getSum(a = data!!)
        }

//        listData
//        pokemonAdapter = PokemonAdapter(array!!,context!!)

        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                var firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (firstVisibleItemPosition >= 0 && (visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                    PAGE += 20
                    val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
                    val pokemonRepository = PokemonRepository(apiInterface)
                    pokemonViewModel = ViewModelProvider(this@PokemonFragment, PokemonViewModelFactory(pokemonRepository,20))[PokemonViewModel::class.java]
                    pokemonViewModel.pokemon.observe(this@PokemonFragment) {
                        var a = it.results as ArrayList<Results>
                        getSum(a = data!!)
                        var array : ArrayList<PokemonDetail> = ArrayList()
                        for(i in 0 until a.size) {
                            val retrofit = Retrofit.Builder()
                                .baseUrl("https://pokeapi.co/api/v2/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                            val retrofitAPI = retrofit.create(ApiInterface::class.java)
                            val call: Call<PokemonDetail> = retrofitAPI.getPokemon(a[i].name)
                            call!!.enqueue(object : Callback<PokemonDetail?> {
                                override fun onResponse(
                                    call: Call<PokemonDetail?>?,
                                    response: Response<PokemonDetail?>
                                ) {
                                    if (response.isSuccessful) {
                                        var list : PokemonDetail = response.body()!!
                                        list?.let {
                                            var sum : PokemonDetail = list
                                            array?.add(sum)
                                            if(i == a.size-1) {
                                                Log.d("QQ", "$array")
                                                pokemonAdapter.updateUserList(array)
                                            }
                                        }
                                    }
                                }
                                override fun onFailure(call: Call<PokemonDetail?>?, t: Throwable?) {
                                    Toast.makeText(context, "Fail to get the data..", Toast.LENGTH_SHORT)
                                        .show()
                                }

                            })
                        }
                    }
                }
            }

        })
    }
    @SuppressLint("FragmentLiveDataObserve", "UseRequireInsteadOfGet")
    private fun getSum(a : ArrayList<Results>) {
        var array : ArrayList<PokemonDetail> = ArrayList()
        for(i in 0 until a.size) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val retrofitAPI = retrofit.create(ApiInterface::class.java)
            val call: Call<PokemonDetail> = retrofitAPI.getPokemon(a[i].name)
            call!!.enqueue(object : Callback<PokemonDetail?> {
                override fun onResponse(
                    call: Call<PokemonDetail?>?,
                    response: Response<PokemonDetail?>
                ) {
                    if (response.isSuccessful) {
                        var list : PokemonDetail = response.body()!!
                        list?.let {
                            var sum : PokemonDetail = list
                            array?.add(sum)
                            if(i == a.size-1) {
                                pokemonAdapter = PokemonAdapter(array!!,context!!)
                                recycleView.layoutManager = GridLayoutManager(context,1)
                                recycleView.adapter = pokemonAdapter
                            }
                        }
                    }
                }
                override fun onFailure(call: Call<PokemonDetail?>?, t: Throwable?) {
                    Toast.makeText(context, "Fail to get the data..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }
}