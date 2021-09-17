package com.ceiba.factoryimplementation.util

import com.ceiba.factoryimplementation.model.Pizza

fun String.filterListPizza (listPizza: MutableList<Pizza>): MutableList<Pizza>{
    val list = listPizza.filter {
        return@filter it.name?.toLowerCase()?.contains(this.toLowerCase())!!
    }
    return list.toMutableList()
}

