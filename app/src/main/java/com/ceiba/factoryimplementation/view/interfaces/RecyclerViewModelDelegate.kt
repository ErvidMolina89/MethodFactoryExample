package com.ceiba.factoryimplementation.view.interfaces

import com.ceiba.factoryimplementation.model.Invoice

interface RecyclerViewModelDelegate {
    fun responseOnClickItemRecycler(invoice: Invoice)
}