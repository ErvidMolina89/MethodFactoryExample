package com.ceiba.factoryimplementation.view.view_model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.util.DialogCostPizza
import com.ceiba.factoryimplementation.util.showDialogCostPizza

class CostViewModel: ViewModel() {

    fun dialogAddVehicle(context: Context, pizza: Pizza){
        DialogCostPizza
            .getInstance()
            .withText(validateCostPizza(pizza).toString())
            .withActionBtnOk {

            }
        context.showDialogCostPizza()
    }

    private fun validateCostPizza(pizza: Pizza): Double{
        return (pizza.count!! * pizza.price!!)
    }
}