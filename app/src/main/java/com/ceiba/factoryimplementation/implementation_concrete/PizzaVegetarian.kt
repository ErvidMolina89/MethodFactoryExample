package com.ceiba.factoryimplementation.implementation_concrete

import com.ceiba.factoryimplementation.interface_pizza.IPizza

class PizzaVegetarian: IPizza {
    override fun getExtraIngredients(): String {
        return "Cebolla, Pimiento"
    }

    override fun getExtraCost(): Double {
        return 10500.0
    }
}