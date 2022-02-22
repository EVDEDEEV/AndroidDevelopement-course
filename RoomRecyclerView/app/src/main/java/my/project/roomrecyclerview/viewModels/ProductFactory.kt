package my.project.roomrecyclerview.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import my.project.roomrecyclerview.repositories.CategoryRepository
import my.project.roomrecyclerview.repositories.ProductRepository

class ProductFactory(private val productRepository: ProductRepository): ViewModelProvider.Factory {
    override fun  <T: ViewModel> create (modelClass: Class<T>) : T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            return ProductViewModel(productRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}
