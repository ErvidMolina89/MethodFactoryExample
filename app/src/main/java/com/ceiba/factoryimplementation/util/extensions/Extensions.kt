package com.ceiba.factoryimplementation.util

import android.content.Context
import com.ceiba.factoryimplementation.model.Pizza

fun String.filterListUser (valor: String, listPizza: MutableList<Pizza>): MutableList<Pizza>{
    val list = listPizza.filter {
        return@filter it.name?.toLowerCase()?.contains(valor.toLowerCase())!!
    }
    return list.toMutableList()
}

fun Context.getListExamplePizza(): MutableList<Pizza>{
    val list = emptyList<Pizza>().toMutableList()
    var pizza = Pizza("ORIGINAL", 1, PizzaType.ORIGINAL.getImage())
    list.add(0, pizza)

    pizza = Pizza("MEATS", 1, PizzaType.MEATS.getImage())
    list.add(1, pizza)

    pizza = Pizza("MEXICAN", 1, PizzaType.MEXICAN.getImage())
    list.add(2, pizza)

    pizza = Pizza("VEGETARIAN", 1, PizzaType.VEGETARIAN.getImage())
    list.add(3, pizza)

    pizza = Pizza("SPECIAL", 1, PizzaType.SPECIAL.getImage())
    list.add(4, pizza)

    return list
}
