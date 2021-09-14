package com.ceiba.factoryimplementation.factory_pizza

import com.ceiba.factoryimplementation.implementation_concrete.*
import com.ceiba.factoryimplementation.interface_pizza.IPizza
import com.ceiba.factoryimplementation.util.PizzaType

object PizzaFactory {

    fun getExtraValuesPizza(type: String): IPizza{
        return when(type){
            PizzaType.ORIGINAL.getName() -> {PizzaOriginal()}
            PizzaType.SPECIAL.getName()  -> {PizzaSpecial()}
            PizzaType.VEGETARIAN.getName()  -> {PizzaVegetarian()}
            PizzaType.MEXICAN.getName()  -> {PizzaMexican()}
            PizzaType.MEATS.getName()  -> {PizzaMeats()}
            else -> {PizzaOriginal()}
        }
    }

}