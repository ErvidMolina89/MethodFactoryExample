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
import com.ceiba.factoryimplementation.view.adapter.view_holder.ViewHolder
import de.hdodenhof.circleimageview.CircleImageView

class MainRecyclerViewAdapter  (
    val context : Context?,
    internal var listPizzas: MutableList<Pizza>
) : RecyclerView.Adapter<ViewHolder>() {

    private var listener: ((Invoice)-> Unit)? = null
    private val minimumValuePizzaQuantity = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.aggregate_list_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item: Pizza = listPizzas[position]
        val factoryValuesPizza = item.name?.let { PizzaFactory.getExtraValuesPizza(it) }
        val invoice = item.name?.let {
            factoryValuesPizza?.let { cost ->
                Invoice(1,
                    cost.getExtraCost(),
                    it
                )
            }
        }
        holder.bindData(item, factoryValuesPizza?.getExtraIngredients(), invoice)

        setOnClickListeners(holder, invoice)
    }

    private fun setOnClickListeners(holder : ViewHolder, invoice : Invoice?){

        var quantity: Int? = invoice?.count

        holder.imageViewAdd.setOnClickListener {
            quantity = quantity?.addOne()
            invoice?.count = quantity
            holder.buttonViewQuantity.text = invoice?.count.toString()
        }
        holder.imageViewSubtract.setOnClickListener {
            if (holder.buttonViewQuantity.text.toString().toInt() > minimumValuePizzaQuantity){
                quantity = quantity?.subtractOne()
                invoice?.count = quantity
                holder.buttonViewQuantity.text = invoice?.count.toString()
            } else context?.createToast("Este es el valor minimo posible")
        }

        holder.buttonOrder.setOnClickListener {
                if (invoice != null) {
                    listener?.invoke(invoice)
                }
                invoice?.count = 1
                notifyDataSetChanged()
            }
    }

    override fun getItemCount(): Int = listPizzas.size

    fun setData(listSearch : MutableList<Pizza>){
        this.listPizzas = listSearch
        notifyDataSetChanged()
    }

    fun onClickListener(listener : (Invoice)-> Unit){
        this.listener = listener
    }
}