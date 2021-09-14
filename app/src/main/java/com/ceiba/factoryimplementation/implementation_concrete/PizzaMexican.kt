package com.ceiba.factoryimplementation.implementation_concrete

import com.ceiba.factoryimplementation.interface_pizza.IPizza

class PizzaMexican: IPizza {
    override fun getExtraIngredients(): String {
        return "Carne Sasonada, Salsa Tabasco, Cebolla, Maiz, Aguacate, limón"
    }

    override fun getExtraCost(): Double {
        return 12500.0
    }
}