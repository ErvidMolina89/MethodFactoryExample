package com.ceiba.factoryimplementation.get_list_pizza

import com.ceiba.factoryimplementation.model.Pizza

interface Repository {
    fun getPizzas(): MutableList<Pizza>
}