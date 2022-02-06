package com.example.room.Tabs.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room.Tabs.categories.CategoriesViewModel
import com.example.room.db.CategoriesRepository
import com.example.room.db.ProductsRepository

class ProductsViewModelFactory (private val productsRepository: ProductsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProductsViewModel::class.java)){
            return ProductsViewModel(productsRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}
