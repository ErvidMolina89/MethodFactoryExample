package com.ceiba.factoryimplementation.implementation_concrete

import com.ceiba.factoryimplementation.interface_pizza.IPizza

class PizzaMeats: IPizza {
    override fun getExtraIngredients(): String {
        return "Salchicha, Chorizo, Peperoni, Jamón"
    }

    override fun getExtraCost(): Double {
        return 12000.0
    }
}