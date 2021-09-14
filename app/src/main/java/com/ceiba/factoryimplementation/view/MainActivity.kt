package com.ceiba.factoryimplementation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.ceiba.factoryimplementation.R
import com.ceiba.factoryimplementation.databinding.ActivityMainBinding
import com.ceiba.factoryimplementation.factory_pizza.PizzaFactory
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.util.PizzaType
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

    private fun createPizza(){
        adapter.setData(this.getListExamplePizza())
        val original = PizzaFactory().getExtraIngredientsPizza(PizzaType.ORIGINAL).getExtraIngredients()
        val special = PizzaFactory().getExtraIngredientsPizza(PizzaType.SPECIAL).getExtraIngredients()
        val vegetarian = PizzaFactory().getExtraIngredientsPizza(PizzaType.VEGETARIAN).getExtraIngredients()
        val mexican = PizzaFactory().getExtraIngredientsPizza(PizzaType.MEXICAN).getExtraIngredients()
        val meats = PizzaFactory().getExtraIngredientsPizza(PizzaType.MEATS).getExtraIngredients()
        Log.e("Ingredients", original + " " + special + " " + vegetarian + " " + mexican + " " + meats)
    }

    private fun costPizza(){
        val original = PizzaFactory().getExtraIngredientsPizza(PizzaType.ORIGINAL).getExtraCost().toString()
        val special = PizzaFactory().getExtraIngredientsPizza(PizzaType.SPECIAL).getExtraCost().toString()
        val vegetarian = PizzaFactory().getExtraIngredientsPizza(PizzaType.VEGETARIAN).getExtraCost().toString()
        val mexican = PizzaFactory().getExtraIngredientsPizza(PizzaType.MEXICAN).getExtraCost().toString()
        val meats = PizzaFactory().getExtraIngredientsPizza(PizzaType.MEATS).getExtraCost().toString()
        Log.e("Ingredients", original + " " + special + " " + vegetarian + " " + mexican + " " + meats)
    }

    override fun onDestroy() {
        super.onDestroy()
//        binding = null
//        adapter = null
    }
}