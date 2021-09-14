package com.ceiba.factoryimplementation.util

import android.content.Context
import android.content.ContextWrapper
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ceiba.factoryimplementation.model.Pizza

fun Context.createToast(mess: String){
    val toast = Toast.makeText(this, mess, Toast.LENGTH_LONG)
    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
    toast.show()
}

fun Context.showDialogCostPizza(){
    if(!isAValidContextToDisplayMessage(this)){ return }
    if(this !is AppCompatActivity){
        getContextValid(this).showDialogCostPizza()
        return
    }
    runOnUiThread {
        DialogCostPizza.getInstance().showDialogue(supportFragmentManager, "Cost Vehicle")
    }
}

private fun isAValidContextToDisplayMessage(contex: Context) : Boolean{
    return contex is AppCompatActivity || contex is ContextWrapper
}

private fun getContextValid(contex : Context) : Context{
    var EndContex : Context = contex
    while((EndContex !is AppCompatActivity) && (EndContex is ContextWrapper)){
        EndContex = (EndContex as ContextWrapper).baseContext
    }
    return EndContex
}


fun Context.getListExamplePizza(): MutableList<Pizza>{
    val list = emptyList<Pizza>().toMutableList()
    var pizza = Pizza(PizzaType.ORIGINAL.getName(), 1, PizzaType.ORIGINAL.getImage())
    list.add(0, pizza)

    pizza = Pizza(PizzaType.MEATS.getName(), 1, PizzaType.MEATS.getImage())
    list.add(1, pizza)

    pizza = Pizza(PizzaType.MEXICAN.getName(), 1, PizzaType.MEXICAN.getImage())
    list.add(2, pizza)

    pizza = Pizza(PizzaType.VEGETARIAN.getName(), 1, PizzaType.VEGETARIAN.getImage())
    list.add(3, pizza)

    pizza = Pizza(PizzaType.SPECIAL.getName(), 1, PizzaType.SPECIAL.getImage())
    list.add(4, pizza)

    return list
}