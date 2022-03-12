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
    fun insert(cardModel: CardModel)

    @Query("SELECT * FROM card_data_table")
    fun loadCoffeeFromCard(): LiveData<List<CardModel>>

    @Query("DELETE FROM card_data_table")
    fun clear()
}
