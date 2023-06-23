package com.sarthak.cryptoapp.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sarthak.cryptoapp.R
import com.sarthak.cryptoapp.adapter.MarketAdapter
import com.sarthak.cryptoapp.apis.ApiUtilities
import com.sarthak.cryptoapp.databinding.FragmentWishListBinding
import com.sarthak.cryptoapp.models.CryptoCurrencyListItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create
import com.sarthak.cryptoapp.apis.ApiInterface as ApiInterface


class WatchListFragment : Fragment() {

    private lateinit var binding: FragmentWishListBinding
    private lateinit var watchList: ArrayList<String>
    private lateinit var watchListItem : ArrayList<CryptoCurrencyListItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWishListBinding.inflate(layoutInflater)
        readData()

        lifecycleScope.launch(Dispatchers.IO){
            val res = ApiUtilities.getInstance().create(ApiInterface::class.java)
                .getMarketData()

            if(res.body()!=null){
                withContext(Dispatchers.Main){
                    watchListItem = ArrayList()
                    watchListItem.clear()

                    for(watchData in watchList){
                        for(item in res.body()!!.data.cryptoCurrencyList!!){
                            if(watchData==item.symbol){
                                watchListItem.add(item)
                            }
                        }
                    }

                    binding.spinKitView.visibility = GONE
                    binding.watchlistRecyclerView.adapter = MarketAdapter(requireContext(), watchListItem, "watchFragment")
                }
            }
        }
        return binding.root
    }

    private fun readData() {
        val sharedPreferences = requireContext().getSharedPreferences("watchlist", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("watchlist", ArrayList<String>().toString())
        val type = object : TypeToken<ArrayList<String>>(){}.type
        watchList = gson.fromJson(json, type)
    }
}