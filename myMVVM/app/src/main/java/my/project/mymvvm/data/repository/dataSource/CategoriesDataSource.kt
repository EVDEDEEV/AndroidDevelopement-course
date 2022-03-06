package my.project.mymvvm.data.repository.dataSource

import androidx.lifecycle.LiveData
import my.project.mymvvm.data.models.CategoriesModel

interface CategoriesDataSource {

    fun insert(categoriesModel: CategoriesModel)

    fun loadCategories(): LiveData<List<CategoriesModel>>

    suspend fun clear()

}