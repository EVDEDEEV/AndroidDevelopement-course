package my.project.cofee.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import my.project.cofee.data.models.CardModel
import my.project.cofee.data.models.CoffeeModel

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cardModel: CardModel)

    @Query("SELECT * FROM card_data_table")
    fun loadCoffeeFromCard(): LiveData<List<CardModel>>

    //Отслеживание нужного товара в корзине по id
    @Query("SELECT * FROM card_data_table WHERE card_idProduct = :idProduct")
    fun loadCoffeeToCardFromCardProduct(idProduct: String): LiveData<List<CardModel>>

    @Query("DELETE FROM card_data_table WHERE card_id = :idProductToCard")
    suspend fun deleteProductFromCard(idProductToCard: Int)

    //Удаление товара по id в другой базе данных
    @Query("DELETE FROM card_data_table WHERE card_idProduct = :idProduct")
    suspend fun deleteProductFromCardProduct(idProduct: Int)

    @Query("DELETE FROM card_data_table")
    suspend fun clear()
}
