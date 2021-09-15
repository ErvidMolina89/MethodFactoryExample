package com.ceiba.factoryimplementation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.factoryimplementation.databinding.ActivityMainBinding
import com.ceiba.factoryimplementation.factory_pizza.PizzaFactory
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.util.PizzaType
import com.ceiba.factoryimplementation.util.filterListPizza
import com.ceiba.factoryimplementation.util.getListExamplePizza
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

    }
}