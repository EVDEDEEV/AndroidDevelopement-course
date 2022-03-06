package my.project.mymvvm.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import my.project.mymvvm.data.models.CategoriesModel

interface CategoriesCall {

    fun loadCategories(): LiveData<List<CategoriesModel>>

    suspend fun startMigration(context: Context)
}