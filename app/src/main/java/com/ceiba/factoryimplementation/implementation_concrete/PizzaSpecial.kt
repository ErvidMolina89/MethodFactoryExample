package com.ceiba.factoryimplementation.implementation_concrete

import com.ceiba.factoryimplementation.interface_pizza.IPizza

class PizzaSpecial: IPizza {
    override fun getExtraIngredients(): String {
        return "Peperoni, Tocino, Salchicha Italiana"
    }

    override fun getExtraCost(): Double {
        return 11000.0
    }
}