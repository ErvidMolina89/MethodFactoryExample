package com.ceiba.factoryimplementation.view.view_model

import android.content.Context
import androidx.lifecycle.ViewModel
import com.ceiba.factoryimplementation.model.Invoice
import com.ceiba.factoryimplementation.util.DialogCostPizza
import com.ceiba.factoryimplementation.util.createToast
import com.ceiba.factoryimplementation.util.showDialogCostPizza

class CostViewModel: ViewModel() {

    private val MINIMUM_AMOUNT_PIZZA = 1

    fun dialogAddVehicle(context: Context, invoice: Invoice){
        DialogCostPizza
            .getInstance()
            .withText(validateCostPizza(invoice).toString())
            .withTextInfo(
                when(invoice.count){
                    MINIMUM_AMOUNT_PIZZA -> {" Es ${invoice.count} pizza de ${invoice.pizzaName}"}
                    else -> {" Son ${invoice.count} pizzas de ${invoice.pizzaName}"}
                }
            )
            .withActionBtnOk {
                context.createToast("Tu pedido se entregará en menos de 20 minutos")
            }
        context.showDialogCostPizza()
    }

    private fun validateCostPizza(invoice: Invoice): Double{
        return (invoice.count!! * invoice.unitPrice!!)
    }
}