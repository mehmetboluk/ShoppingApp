package com.mehmetboluk.shoppingapp.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.mehmetboluk.shoppingapp.databinding.DialogBoxBinding
import com.mehmetboluk.shoppingapp.model.ShoppingItem

class ShoppingItemDialog(context: Context, var addDialogListener : AddDialogListener) : AppCompatDialog(context) {

    private lateinit var binding: DialogBoxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()

            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Please enter all information", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name,amount.toInt() )
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }
    }
}