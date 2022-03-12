package my.project.cofee.domain.repository

import androidx.lifecycle.LiveData
import my.project.cofee.data.models.CardModel

interface CardCall {

    suspend fun insert(cardModel: CardModel)

    fun loadCoffeeFromCard(): LiveData<List<CardModel>>

    fun loadCoffeeToCardFromCardProduct(idProduct: String): LiveData<List<CardModel>>

    suspend fun clear()


}