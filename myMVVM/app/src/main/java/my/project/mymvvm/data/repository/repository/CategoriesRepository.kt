package my.project.mymvvm.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.mymvvm.data.models.CategoriesModel
import my.project.mymvvm.data.repository.dataSource.CategoriesApiDataSource
import my.project.mymvvm.data.repository.dataSource.CategoriesDataSource
import my.project.mymvvm.domain.repository.CategoriesCall

class CategoriesRepository (private val categoriesApiDataSource: CategoriesApiDataSource,
                            private val categoriesDataSource: CategoriesDataSource
): CategoriesCall {

    override fun loadCategories(): LiveData<List<CategoriesModel>> {
        return categoriesDataSource.loadCategories()
    }

    override suspend fun startMigration(context: Context) {
        categoriesDataSource.clear()
        categoriesApiDataSource.startMigration(context)
    }

}