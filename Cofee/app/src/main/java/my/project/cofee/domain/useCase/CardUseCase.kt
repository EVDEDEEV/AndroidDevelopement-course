package my.project.cofee.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.cofee.data.models.CardModel
import my.project.cofee.data.models.CoffeeModel
import my.project.cofee.domain.repository.CardCall
import my.project.cofee.domain.repository.CoffeeCall

class CardUseCase(private val cardCall: CardCall) {

    suspend fun insert(cardModel: CardModel) {
        cardCall.insert(cardModel)
    }

    fun loadCoffeeFromCard(): LiveData<List<CardModel>> {
        return cardCall.loadCoffeeFromCard()
    }

    fun loadCoffeeToCardFromCardProduct(idProduct: String): LiveData<List<CardModel>> {
        return cardCall.loadCoffeeToCardFromCardProduct(idProduct)
    }

    suspend fun clear() {
        cardCall.clear()
    }


}