package my.project.roomrecyclerview.data

import androidx.lifecycle.LiveData
import androidx.room.*
import my.project.roomrecyclerview.models.ProductModel

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProduct(productModel: ProductModel)

    @Update
    suspend fun updateProduct(productModel: ProductModel)

    @Delete
    suspend fun deleteProduct(productModel: ProductModel)

    @Query("DELETE FROM product_data_table")
    suspend fun deleteAllProducts()

    @Query("SELECT*FROM product_data_table")
    fun getAllProducts(): LiveData<List<ProductModel>>

    @Query("SELECT*FROM product_data_table WHERE product_category = :nameCategory AND product_price =:priceCategory ")
    fun getFilter(nameCategory:String, priceCategory: String): LiveData<List<ProductModel>>

}