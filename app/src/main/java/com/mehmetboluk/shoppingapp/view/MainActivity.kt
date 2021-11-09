package com.mehmetboluk.shoppingapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mehmetboluk.shoppingapp.adapter.ShoppingAdapter
import com.mehmetboluk.shoppingapp.databinding.ActivityMainBinding
import com.mehmetboluk.shoppingapp.model.ShoppingDatabase
import com.mehmetboluk.shoppingapp.model.ShoppingItem
import com.mehmetboluk.shoppingapp.viewModel.ShoppingRepository
import com.mehmetboluk.shoppingapp.viewModel.ShoppingViewModel
import com.mehmetboluk.shoppingapp.viewModel.ShoppingViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingAdapter(listOf(), viewModel)
        binding.rvShopping.layoutManager = LinearLayoutManager(this)
        binding.rvShopping.adapter = adapter

        viewModel.getAllItem().observe(this, Observer {
            adapter.list = it
        })

        binding.fab.setOnClickListener {
            ShoppingItemDialog(this,object : AddDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }

    }
}