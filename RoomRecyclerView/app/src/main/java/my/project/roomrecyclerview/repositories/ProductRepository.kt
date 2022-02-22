package my.project.roomrecyclerview.repositories

import androidx.lifecycle.LiveData
import my.project.roomrecyclerview.data.CategoryDao
import my.project.roomrecyclerview.data.ProductDao
import my.project.roomrecyclerview.models.CategoryModel
import my.project.roomrecyclerview.models.ProductModel

class ProductRepository(private val productDao: ProductDao) {
    val products = productDao.getAllProducts()

    fun getFilter(nameCategory: String, priceProduct: String):
            LiveData<List<ProductModel>> {
        return productDao.getFilter(nameCategory, priceProduct)
    }

    suspend fun insertProduct(productModel: ProductModel) {
        productDao.insertProduct(productModel)
    }

    suspend fun updateProduct(productModel: ProductModel) {
        productDao.updateProduct(productModel)
    }

    suspend fun deleteProduct(productModel: ProductModel) {
        productDao.deleteProduct(productModel)
    }

    suspend fun deleteAllProducts() {
        productDao.deleteAllProducts()
    }
}