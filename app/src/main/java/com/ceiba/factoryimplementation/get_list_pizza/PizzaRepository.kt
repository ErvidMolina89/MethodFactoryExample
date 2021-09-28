package com.ceiba.factoryimplementation.get_list_pizza

import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.util.PizzaType

class PizzaRepository: Repository {
    override fun getPizzas(): MutableList<Pizza> {
        val list = emptyList<Pizza>().toMutableList()
        var pizza = Pizza(PizzaType.ORIGINAL.getName(), PizzaType.ORIGINAL.getImage())
        list.add(0, pizza)

        pizza = Pizza(PizzaType.MEATS.getName(), PizzaType.MEATS.getImage())
        list.add(1, pizza)

        pizza = Pizza(PizzaType.MEXICAN.getName(), PizzaType.MEXICAN.getImage())
        list.add(2, pizza)

        pizza = Pizza(PizzaType.VEGETARIAN.getName(), PizzaType.VEGETARIAN.getImage())
        list.add(3, pizza)

        pizza = Pizza(PizzaType.SPECIAL.getName(), PizzaType.SPECIAL.getImage())
        list.add(4, pizza)

        return list
    }
}