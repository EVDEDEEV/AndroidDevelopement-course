package my.project.mymvvm.data.repository.dataSourceIMPL

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import my.project.mymvvm.data.localDB.CategoriesDao
import my.project.mymvvm.data.models.CategoriesModel
import my.project.mymvvm.data.repository.dataSource.CategoriesDataSource

class CategoriesDataSourceIMPL (private val dao: CategoriesDao):
    CategoriesDataSource {


    override fun insert(categoriesModel: CategoriesModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(categoriesModel)}
    }

    override fun loadCategories(): LiveData<List<CategoriesModel>> {
        return dao.loadCategories()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }



}