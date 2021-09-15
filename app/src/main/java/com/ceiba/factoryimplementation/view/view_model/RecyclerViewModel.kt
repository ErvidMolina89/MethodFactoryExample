package com.ceiba.factoryimplementation.view.view_model

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.factoryimplementation.databinding.ActivityMainBinding
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.util.filterListPizza
import com.ceiba.factoryimplementation.util.getListExamplePizza
import com.ceiba.factoryimplementation.view.MainActivity
import com.ceiba.factoryimplementation.view.adapter.MainRecyclerViewAdapter
import com.ceiba.factoryimplementation.view.interfaces.RecyclerViewModelDelegate
import java.util.*

class RecyclerViewModel: ViewModel(){


    private lateinit var delegate: RecyclerViewModelDelegate

    private lateinit var binding: ActivityMainBinding
    @SuppressLint("StaticFieldLeak")
    private lateinit var context: MainActivity
    private lateinit var adapter: MainRecyclerViewAdapter

    fun onStyleRecycler(binding: ActivityMainBinding, context: MainActivity) {
        this.binding = binding
        this.context = context
        binding.recyclerViewSearchResults.let {
            it.layoutManager  = LinearLayoutManager(context)
            context.adapter = MainRecyclerViewAdapter(
                context,
                emptyList<Pizza>().toMutableList()
            )
            binding.recyclerViewSearchResults.adapter = context.adapter
        }
    }

    fun listenerRecycler(adapter: MainRecyclerViewAdapter){
        this.adapter = adapter
        adapter.let {
            adapter.onClickListener {
                delegate.responseOnClickItemRecycler(it)
            }
        }
    }

    fun setDataListPizza(){
        adapter.setData(context.getListExamplePizza())
    }

    fun listenerEditTextSearch(){
        binding.editTextSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() != ""){
                    adapter.setData(p0.toString().filterListPizza(context.getListExamplePizza()))
                }else adapter.setData(context.getListExamplePizza())}

            override fun afterTextChanged(p0: Editable?) {}

        })
    }

    fun setDelegate(delegate: RecyclerViewModelDelegate) {
        this.delegate = delegate
    }
}