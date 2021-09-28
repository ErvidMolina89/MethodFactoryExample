package com.ceiba.factoryimplementation.view.view_model

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel
import com.ceiba.factoryimplementation.databinding.ActivityMainBinding
import com.ceiba.factoryimplementation.get_list_pizza.PizzaRepository
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.util.filterListPizza
import com.ceiba.factoryimplementation.view.adapter.MainRecyclerViewAdapter
import com.ceiba.factoryimplementation.view.interfaces.RecyclerViewModelDelegate

class RecyclerViewModel: ViewModel(){


    private lateinit var delegate: RecyclerViewModelDelegate
    private var list: MutableList<Pizza> = emptyList<Pizza>().toMutableList()

    private lateinit var adapter: MainRecyclerViewAdapter

    fun listenerRecycler(adapter: MainRecyclerViewAdapter){
        this.adapter = adapter
        adapter.let {
            adapter.onClickListener {
                delegate.responseOnClickItemRecycler(it)
            }
        }
    }

    fun setDataListPizza(){
        if (list.size == 0) {
            list = PizzaRepository().getPizzas()
            adapter.setData(list)
        }
    }

    fun listenerEditTextSearch(binding: ActivityMainBinding){
        binding.editTextSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() != ""){
                    adapter.setData(p0.toString().filterListPizza(PizzaRepository().getPizzas()))
                }else adapter.setData(list)}

            override fun afterTextChanged(p0: Editable?) {}

        })
    }

    fun setDelegate(delegate: RecyclerViewModelDelegate) {
        this.delegate = delegate
    }
}