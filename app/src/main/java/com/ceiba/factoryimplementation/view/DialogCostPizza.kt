package com.ceiba.factoryimplementation.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ceiba.factoryimplementation.R

class DialogCostPizza  private constructor()
    : DialogFragment() {

    companion object{
        private var showingDialog = false
        @SuppressLint("StaticFieldLeak")
        private var instance : DialogCostPizza?= null
        private var routeText : String ?= null
        private var routeTextInfo : String ?= null

        fun getInstance() : DialogCostPizza {
            if(instance == null )
            {
                instance = DialogCostPizza()
            }
            return instance!!
        }
    }

    private var image_dialogue_cost : ImageView?= null
    private var title : TextView?= null
    private var details_info : TextView?= null
    private var details_message : TextView?= null
    private var btn_ok : Button?= null
    private var btn_cancel : Button?= null

    private var mainContainer : View?= null
    private var invokesActionOk:(()->Unit)?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mainContainer = inflater.inflate(R.layout.dialog_cost_vehicle,null,false)
        isCancelable = false

        findsViewElements()
        addListeners()
        return mainContainer
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findsViewElements()
        addListeners()

    }

    override fun onResume() {
        super.onResume()
        if(routeText != null){
            details_message?.visibility = View.VISIBLE
            details_message?.setText(routeText!!)
        }
        if(routeTextInfo != null){
            details_info?.visibility = View.VISIBLE
            details_info?.setText(routeTextInfo!!)
        }
    }

    private fun findsViewElements(){

        image_dialogue_cost = mainContainer?.findViewById(R.id.image_dialogue_cost)
        details_message     = mainContainer?.findViewById(R.id.details_mess_cost)
        details_info        = mainContainer?.findViewById(R.id.details_mess_info)
        title               = mainContainer?.findViewById(R.id.title_cost_dialog)
        btn_ok              = mainContainer?.findViewById(R.id.btn_accept_cost)
        btn_cancel          = mainContainer?.findViewById(R.id.btn_cancel_cost)

    }

    private fun addListeners(){
        btn_cancel?.setOnClickListener {
            dismiss()
        }

        btn_ok?.setOnClickListener {
            dismiss()
            invokesActionOk?.invoke()
            cleanElementsOfSight()
        }
    }

    private fun cleanElementsOfSight(){
        invokesActionOk = null
        details_message = null
        routeText = null
    }

    override fun dismiss() {
        showingDialog = false
        if(fragmentManager == null ){
            return
        }
        super.dismiss()
        super.dismissAllowingStateLoss()
    }

    override fun onStart() {
        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        super.onStart()
    }

    override fun show(manager: FragmentManager, tag: String?) {
        try {
            if(showingDialog){ return }
            if(isAdded){ return }
            showingDialog = true
            super.show(manager, tag)
        }catch (e : Exception) {
            e.printStackTrace()
        }
    }

    fun withActionBtnOk(actionOk : ()->Unit) : DialogCostPizza {
        this.invokesActionOk = actionOk
        return this
    }

    fun withText(routeString : String): DialogCostPizza {
        routeText = routeString
        return this
    }

    fun withTextInfo(routeString : String): DialogCostPizza {
        routeTextInfo = routeString
        return this
    }

    fun showDialogue(fragmentManager: FragmentManager, etiqueta : String){
        show(fragmentManager,etiqueta)
    }

}