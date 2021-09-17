package com.ceiba.factoryimplementation.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ceiba.factoryimplementation.databinding.ActivityMainBinding
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.view.adapter.MainRecyclerViewAdapter
import com.ceiba.factoryimplementation.view.interfaces.RecyclerViewModelDelegate
import com.ceiba.factoryimplementation.view.view_model.CostViewModel
import com.ceiba.factoryimplementation.view.view_model.RecyclerViewModel
import java.util.*

class MainActivity : AppCompatActivity(), RecyclerViewModelDelegate {

    private val recyclerViewModel: RecyclerViewModel by viewModels()
    private val costViewModel: CostViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    var adapter: MainRecyclerViewAdapter = MainRecyclerViewAdapter(this, emptyList<Pizza>().toMutableList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //delegates
        recyclerViewModel.setDelegate(this)

        //call recycler
        recyclerViewModel.onStyleRecycler(binding, this@MainActivity)
        recyclerViewModel.listenerRecycler(adapter)
        recyclerViewModel.listenerEditTextSearch()
        recyclerViewModel.setDataListPizza()

    }

    override fun responseOnClickItemRecycler(pizza: Pizza) {
        costViewModel.dialogAddVehicle(this, pizza)
    }
}