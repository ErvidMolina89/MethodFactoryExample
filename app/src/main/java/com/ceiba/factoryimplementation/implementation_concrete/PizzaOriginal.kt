package com.ceiba.factoryimplementation.implementation_concrete

import com.ceiba.factoryimplementation.interface_pizza.IPizza

class PizzaOriginal: IPizza {
    override fun getExtraIngredients(): String {
        return "Peperoni"
    }

    override fun getExtraCost(): Double {
        return 10000.0
    }
}