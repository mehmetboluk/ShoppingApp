package com.mehmetboluk.shoppingapp.view

import com.mehmetboluk.shoppingapp.model.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item : ShoppingItem)
}