package com.ceiba.factoryimplementation.view.view_model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.ceiba.factoryimplementation.factory_pizza.PizzaFactory
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.util.DialogCostPizza
import com.ceiba.factoryimplementation.util.createToast
import com.ceiba.factoryimplementation.util.showDialogCostPizza

class CostViewModel: ViewModel() {

    fun dialogAddVehicle(context: Context, pizza: Pizza){
        DialogCostPizza
            .getInstance()
            .withText(validateCostPizza(pizza).toString())
            .withTextInfo(
                when(pizza.count){
                    1 -> {" Es ${pizza.count} pizza de ${pizza.name}"}
                    else -> {" Son ${pizza.count} pizzas de ${pizza.name}"}
                }
            )
            .withActionBtnOk {
                context.createToast("Tu pedido se entregará en menos de 20 minutos")
            }
        context.showDialogCostPizza()
    }

    private fun validateCostPizza(pizza: Pizza): Double{
        return (pizza.count!! * PizzaFactory.getExtraValuesPizza(pizza.name!!).getExtraCost())
    }
}