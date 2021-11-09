package com.mehmetboluk.shoppingapp.model

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mehmetboluk.shoppingapp.model.ShoppingItem

@Dao
interface ShoppingDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ShoppingItem)
    @Delete
    suspend fun delete(item : ShoppingItem)
    @Query("SELECT * FROM shopping_table")
    fun getAllItems() : LiveData<List<ShoppingItem>>
}