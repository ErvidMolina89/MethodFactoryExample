package com.ceiba.factoryimplementation.factory_pizza

import com.ceiba.factoryimplementation.implementation_concrete.*
import com.ceiba.factoryimplementation.interface_pizza.IPizza
import com.ceiba.factoryimplementation.util.PizzaType

class PizzaFactory {

    fun getExtraIngredientsPizza(type: PizzaType): IPizza{
        return when(type){
            PizzaType.ORIGINAL -> {PizzaOriginal()}
            PizzaType.SPECIAL -> {PizzaSpecial()}
            PizzaType.VEGETARIAN -> {PizzaVegetarian()}
            PizzaType.MEXICAN -> {PizzaMexican()}
            PizzaType.MEATS -> {PizzaMeats()}
        }
    }

}