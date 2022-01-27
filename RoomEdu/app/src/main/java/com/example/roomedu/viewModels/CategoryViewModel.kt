package com.example.roomedu.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomedu.models.CategoryModel
import com.example.roomedu.repositories.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    val categories = categoryRepository.categories

    fun startInsert(nameCategories:String) {
        insert(CategoryModel(0, nameCategories))
    }

    fun startUpdateProduct(idCategories:Int, nameCategories:String) {
        updateProduct(CategoryModel(idCategories, nameCategories))
    }

    fun insert(categoryModel: CategoryModel) = viewModelScope.launch{

        categoryRepository.insertCategory(categoryModel)
    }

    fun updateProduct(categoryModel: CategoryModel) = viewModelScope.launch{

        categoryRepository.updateCategory(categoryModel)
    }

    fun delete(categoryModel: CategoryModel) = viewModelScope.launch{

        categoryRepository.deleteCategory(categoryModel)
    }

    fun deleteAll() = viewModelScope.launch{

        categoryRepository.deleteAllCategories()
    }


}