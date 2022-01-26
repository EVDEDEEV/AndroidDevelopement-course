package my.project.roomrecyclerview.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.project.roomrecyclerview.models.CategoryModel
import my.project.roomrecyclerview.repositories.CategoryRepository

class CategoryViewModel(private val categoriyRepository: CategoryRepository) : ViewModel() {

    val categories = categoriyRepository.categories

    fun startInsert(nameCategories:String) {
        insert(CategoryModel(0, nameCategories))
    }

    fun startUpdateProduct(idCategories:Int, nameCategories:String) {
        updateProduct(CategoryModel(idCategories, nameCategories))
    }

    fun insert(categoryModel: CategoryModel) = viewModelScope.launch{

        categoriyRepository.insertCategory(categoryModel)
    }

    fun updateProduct(categoryModel: CategoryModel) = viewModelScope.launch{

        categoriyRepository.updateCategory(categoryModel)
    }

    fun delete(categoryModel: CategoryModel) = viewModelScope.launch{

        categoriyRepository.deleteCategory(categoryModel)
    }

    fun deleteAll() = viewModelScope.launch{

       categoriyRepository.deleteAllCategories()
    }


}