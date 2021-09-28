package com.ceiba.factoryimplementation.util

import android.content.Context
import android.content.ContextWrapper
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.view.DialogCostPizza

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