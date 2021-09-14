package com.ceiba.factoryimplementation.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ceiba.factoryimplementation.R
import com.ceiba.factoryimplementation.factory_pizza.PizzaFactory
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.util.*
import de.hdodenhof.circleimageview.CircleImageView

class MainRecyclerViewAdapter  (
    val context : Context?,
    private var mValues: MutableList<Pizza>
) : RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {

    private var listener: ((Pizza)-> Unit)? = null
    private val minimumValuePizzaQuantity = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.aggregate_list_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item: Pizza = mValues[position]

        holder.image_pizza.showImage(item.imageView)
        holder.textViewNamePizza.text = item.name
        holder.textViewPricePizza.text = PizzaFactory.getExtraValuesPizza(item.name!!).getExtraCost().toString()
        holder.textViewIngredientsPizza.text = PizzaFactory.getExtraValuesPizza(item.name!!).getExtraIngredients()

        setOnClickListeners(holder,item)
    }

    private fun setOnClickListeners(holder : ViewHolder, item : Pizza){

        var quantity: Int = item.count!!

        holder.imageViewAdd.setOnClickListener {
            quantity = quantity.addOne()
            holder.buttonViewQuantity.text = quantity.toString()
            item.count = quantity
        }
        holder.imageViewSubtract.setOnClickListener {
            if (holder.buttonViewQuantity.text.toString().toInt() > minimumValuePizzaQuantity){
                quantity = quantity.subtractOne()
                holder.buttonViewQuantity.text = quantity.toString()
                item.count = quantity
            } else context?.createToast("Este es el valor minimo posible")
        }

        holder.buttonOrder.setOnClickListener {
                listener?.invoke(item)
            }
    }

    override fun getItemCount(): Int = mValues.size

    fun setData(listSearch : MutableList<Pizza>){
        this.mValues = listSearch
        notifyDataSetChanged()
    }

    fun onClickListener(listener : (Pizza)-> Unit){
        this.listener = listener
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        val image_pizza              : CircleImageView = mView.findViewById(R.id.circleImageViewPizza)
        val textViewNamePizza        : TextView = mView.findViewById(R.id.textViewNamePizza)
        val textViewPricePizza       : TextView = mView.findViewById(R.id.textViewPricePizza)
        val imageViewSubtract        : ImageView = mView.findViewById(R.id.imageViewSubtract)
        val imageViewAdd             : ImageView = mView.findViewById(R.id.imageViewAdd)
        val buttonViewQuantity       : TextView = mView.findViewById(R.id.buttonViewQuantity)
        val textViewIngredientsPizza : TextView = mView.findViewById(R.id.textViewIngredientsPizza)
        val buttonOrder              : TextView = mView.findViewById(R.id.buttonOrder)

    }
}