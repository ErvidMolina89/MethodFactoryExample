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
import com.ceiba.factoryimplementation.model.Invoice
import com.ceiba.factoryimplementation.model.Pizza
import com.ceiba.factoryimplementation.util.addOne
import com.ceiba.factoryimplementation.util.createToast
import com.ceiba.factoryimplementation.util.showImage
import com.ceiba.factoryimplementation.util.subtractOne
import de.hdodenhof.circleimageview.CircleImageView

class MainRecyclerViewAdapter  (
    val context : Context?,
    private var mValues: MutableList<Pizza>
) : RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {

    private var listener: ((Invoice)-> Unit)? = null
    private val minimumValuePizzaQuantity = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.aggregate_list_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item: Pizza = mValues[position]
        val invoice = Invoice(1,
            PizzaFactory.getExtraValuesPizza(item.name!!).getExtraCost(),
            item.name!!
        )

        holder.image_pizza.showImage(item.imageView)
        holder.textViewNamePizza.text = item.name
        holder.textViewPricePizza.text = PizzaFactory.getExtraValuesPizza(item.name!!).getExtraCost().toString()
        holder.textViewIngredientsPizza.text = PizzaFactory.getExtraValuesPizza(item.name!!).getExtraIngredients()
        holder.buttonViewQuantity.text = invoice.count.toString()

        setOnClickListeners(holder, invoice)
    }

    private fun setOnClickListeners(holder : ViewHolder, invoice : Invoice){

        var quantity: Int = invoice.count!!

        holder.imageViewAdd.setOnClickListener {
            quantity = quantity.addOne()
            invoice.count = quantity
            holder.buttonViewQuantity.text = invoice.count.toString()
        }
        holder.imageViewSubtract.setOnClickListener {
            if (holder.buttonViewQuantity.text.toString().toInt() > minimumValuePizzaQuantity){
                quantity = quantity.subtractOne()
                invoice.count = quantity
                holder.buttonViewQuantity.text = invoice.count.toString()
            } else context?.createToast("Este es el valor minimo posible")
        }

        holder.buttonOrder.setOnClickListener {
                listener?.invoke(invoice)
                invoice.count = 1
                notifyDataSetChanged()
            }
    }

    override fun getItemCount(): Int = mValues.size

    fun setData(listSearch : MutableList<Pizza>){
        this.mValues = listSearch
        notifyDataSetChanged()
    }

    fun onClickListener(listener : (Invoice)-> Unit){
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