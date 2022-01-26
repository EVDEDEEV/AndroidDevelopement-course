package my.project.roomrecyclerview.repositories

import androidx.lifecycle.LiveData
import my.project.roomrecyclerview.data.ProductDao
import my.project.roomrecyclerview.models.ProductModel

class ProductRepository (private val productDAO: ProductDao) {

    val products = productDAO.getAllProducts()

    fun getFilter (nameCategory:String, priceProduct:String):
            LiveData<List<ProductModel>> {
        return productDAO.getFilter(nameCategory, priceProduct)
    }


    suspend fun insertProduct(productModel: ProductModel){
        productDAO.insertProduct(productModel)
    }

    suspend fun updateProduct(productModel: ProductModel){
       productDAO.updateProduct(productModel)
    }

    suspend fun deleteProduct(productModel: ProductModel) {
        productDAO.deleteProduct(productModel)
    }

    suspend fun deleteAllProducts(){
        productDAO.deleteAllProducts()
    }
}
