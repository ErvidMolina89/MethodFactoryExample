package com.ceiba.factoryimplementation.view.interfaces

import com.ceiba.factoryimplementation.model.Pizza

interface RecyclerViewModelDelegate {
    fun responseOnClickItemRecycler(pizza: Pizza)
}