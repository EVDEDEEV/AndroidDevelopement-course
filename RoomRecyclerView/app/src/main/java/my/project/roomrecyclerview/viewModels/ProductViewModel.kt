package my.project.roomrecyclerview.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.project.roomrecyclerview.models.CategoryModel
import my.project.roomrecyclerview.models.ProductModel
import my.project.roomrecyclerview.repositories.CategoryRepository
import my.project.roomrecyclerview.repositories.ProductRepository

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {

    val products = productRepository.products

    fun getFilter(nameCategory: String, priceProduct: String):
            LiveData<List<ProductModel>> {
        return productRepository.getFilter(nameCategory, priceProduct)
    }

    fun startInsert(nameProduct: String, categoryProduct:String, priceProduct: String) {
        insertProduct(ProductModel(0, nameProduct, categoryProduct, priceProduct))
    }

    fun startUpdateProduct(idCategories: Int, nameProduct: String, categoryProduct: String, priceProduct: String) {
        updateProduct(ProductModel(idCategories, nameProduct, categoryProduct, priceProduct))
    }

    fun insertProduct(productModel: ProductModel) = viewModelScope.launch {
        productRepository.insertProduct(productModel)
    }

    fun insert(productModel: ProductModel) = viewModelScope.launch {
        productRepository.insertProduct(productModel)
    }

    fun updateProduct(productModel: ProductModel) = viewModelScope.launch {
        productRepository.updateProduct(productModel)
    }

    fun deleteProduct(productModel: ProductModel) = viewModelScope.launch {
        productRepository.deleteProduct(productModel)
    }

    fun deleteAllProducts() = viewModelScope.launch {
        productRepository.deleteAllProducts()
    }
}
