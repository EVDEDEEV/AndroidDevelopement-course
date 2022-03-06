package my.project.mymvvm.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.mymvvm.data.models.CategoriesModel
import my.project.mymvvm.domain.repository.CategoriesCall

class CategoriesUseCase (private val categoriesCall: CategoriesCall) {


    fun loadCategories(): LiveData<List<CategoriesModel>> {

        return categoriesCall.loadCategories()

    }

    suspend fun startMigration (context: Context) {

        categoriesCall.startMigration(context)

    }



}