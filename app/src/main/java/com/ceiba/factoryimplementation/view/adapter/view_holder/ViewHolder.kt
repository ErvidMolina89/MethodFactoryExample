package com.ceiba.factoryimplementation.view.adapter.view_holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.factoryimplementation.R
import com.ceiba.factoryimplementation.model.Invoice
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.util.showImage
import de.hdodenhof.circleimageview.CircleImageView

class ViewHolder (mView: View): RecyclerView.ViewHolder(mView) {

    val image_pizza              : CircleImageView = mView.findViewById(R.id.circleImageViewPizza)
    val textViewNamePizza        : TextView = mView.findViewById(R.id.textViewNamePizza)
    val textViewPricePizza       : TextView = mView.findViewById(R.id.textViewPricePizza)
    val imageViewSubtract        : ImageView = mView.findViewById(R.id.imageViewSubtract)
    val imageViewAdd             : ImageView = mView.findViewById(R.id.imageViewAdd)
    val buttonViewQuantity       : TextView = mView.findViewById(R.id.buttonViewQuantity)
    val textViewIngredientsPizza : TextView = mView.findViewById(R.id.textViewIngredientsPizza)
    val buttonOrder              : TextView = mView.findViewById(R.id.buttonOrder)


    fun bindData(item: Pizza, ingredients: String?, invoice : Invoice?){
        image_pizza.showImage(item.imageView)
        textViewNamePizza.text = item.name
        textViewPricePizza.text = invoice?.unitPrice?.toString()
        textViewIngredientsPizza.text = ingredients
        buttonViewQuantity.text = invoice?.count?.toString()
    }
}