package com.mehmetboluk.shoppingapp.viewModel

import com.mehmetboluk.shoppingapp.model.ShoppingDatabase
import com.mehmetboluk.shoppingapp.model.ShoppingItem

class ShoppingRepository(private val db : ShoppingDatabase) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDAO().upsert(item)
    suspend fun delete(item: ShoppingItem) = db.getShoppingDAO().delete(item)
    fun getAllItem() = db.getShoppingDAO().getAllItems()
}