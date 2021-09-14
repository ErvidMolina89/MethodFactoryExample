package com.ceiba.factoryimplementation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.factoryimplementation.databinding.ActivityMainBinding
import com.ceiba.factoryimplementation.factory_pizza.PizzaFactory
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.util.PizzaType
import com.ceiba.factoryimplementation.util.filterListPizza
import com.ceiba.factoryimplementation.util.getListExamplePizza
import com.ceiba.factoryimplementation.view.adapter.MainRecyclerViewAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: MainRecyclerViewAdapter = MainRecyclerViewAdapter(this, emptyList<Pizza>().toMutableList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onStyleRecycler()
        listenerRecycler()
        listenerEditTextSearch()

        adapter.setData(this.getListExamplePizza())

        createPizza()
        costPizza()

    }

    private fun onStyleRecycler() {
        binding.recyclerViewSearchResults.let {
            it.layoutManager  = LinearLayoutManager(this)
            this@MainActivity.adapter = MainRecyclerViewAdapter(
                this,
                emptyList<Pizza>().toMutableList()
            )
            binding.recyclerViewSearchResults.adapter = this@MainActivity.adapter
        }
    }

    private fun listenerRecycler(){
        adapter.let {
            adapter.onClickListener {
                val dateExit = Date()
            }
        }
    }

    private fun listenerEditTextSearch(){
        binding.editTextSearch.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString() != ""){
                    adapter.setData(p0.toString().filterListPizza(this@MainActivity.getListExamplePizza()))
                }else adapter.setData(this@MainActivity.getListExamplePizza())}

            override fun afterTextChanged(p0: Editable?) {}

        })
    }

    private fun createPizza(){
        val original = PizzaFactory.getExtraValuesPizza(PizzaType.ORIGINAL.getName()).getExtraIngredients()
        val special = PizzaFactory.getExtraValuesPizza(PizzaType.SPECIAL.getName()).getExtraIngredients()
        val vegetarian = PizzaFactory.getExtraValuesPizza(PizzaType.VEGETARIAN.getName()).getExtraIngredients()
        val mexican = PizzaFactory.getExtraValuesPizza(PizzaType.MEXICAN.getName()).getExtraIngredients()
        val meats = PizzaFactory.getExtraValuesPizza(PizzaType.MEATS.getName()).getExtraIngredients()
        Log.e("Ingredients", original + " " + special + " " + vegetarian + " " + mexican + " " + meats)
    }

    private fun costPizza(){
        val original = PizzaFactory.getExtraValuesPizza(PizzaType.ORIGINAL.getName()).getExtraCost().toString()
        val special = PizzaFactory.getExtraValuesPizza(PizzaType.SPECIAL.getName()).getExtraCost().toString()
        val vegetarian = PizzaFactory.getExtraValuesPizza(PizzaType.VEGETARIAN.getName()).getExtraCost().toString()
        val mexican = PizzaFactory.getExtraValuesPizza(PizzaType.MEXICAN.getName()).getExtraCost().toString()
        val meats = PizzaFactory.getExtraValuesPizza(PizzaType.MEATS.getName()).getExtraCost().toString()
        Log.e("Ingredients", original + " " + special + " " + vegetarian + " " + mexican + " " + meats)
    }

    override fun onDestroy() {
        super.onDestroy()
//        binding = null
//        adapter = null
    }
}