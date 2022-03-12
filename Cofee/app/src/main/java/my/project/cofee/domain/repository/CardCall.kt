package my.project.cofee.domain.repository

import androidx.lifecycle.LiveData
import my.project.cofee.data.models.CardModel

interface CardCall {

    fun insert(cardModel: CardModel)

    fun loadCoffeeFromCard(): LiveData<List<CardModel>>

    fun loadCoffeeToCardFromCardProduct(idProduct: String): LiveData<List<CardModel>>

}