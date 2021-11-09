package com.mehmetboluk.shoppingapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_table")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var name : String,
    @ColumnInfo(name = "item_amount")
    var amaount : Int) {
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}