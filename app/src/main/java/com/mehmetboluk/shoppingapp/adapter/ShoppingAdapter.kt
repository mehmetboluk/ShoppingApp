package com.mehmetboluk.shoppingapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.mehmetboluk.shoppingapp.R
import com.mehmetboluk.shoppingapp.model.ShoppingItem
import com.mehmetboluk.shoppingapp.viewModel.ShoppingViewModel

class ShoppingAdapter(var list : List<ShoppingItem>,private val viewModel: ShoppingViewModel) : RecyclerView.Adapter<ShoppingAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name : TextView = itemView.findViewById(R.id.tvName)
        val amount : TextView = itemView.findViewById(R.id.tvAmount)
        val ivPlus : ImageView = itemView.findViewById(R.id.ivPlus)
        val ivMinus : ImageView = itemView.findViewById(R.id.ivMinus)
        val ivDelete : ImageView = itemView.findViewById(R.id.ivDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_shopping,parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val currentItem = list[position]
        holder.name.text = currentItem.name.toString()
        holder.amount.text = currentItem.amaount.toString()

        holder.ivDelete.setOnClickListener {
            viewModel.delete(currentItem)
        }
        holder.ivPlus.setOnClickListener {
            currentItem.amaount++
            viewModel.upsert(currentItem)
        }
        holder.ivMinus.setOnClickListener {
           if(currentItem.amaount>0){
               currentItem.amaount--
               viewModel.upsert(currentItem)
           }
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }
}