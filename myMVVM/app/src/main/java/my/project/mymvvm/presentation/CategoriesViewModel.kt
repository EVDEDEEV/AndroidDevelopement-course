package my.project.mymvvm.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import my.project.mymvvm.domain.useCase.CategoriesUseCase

class CategoriesViewModel (private val categoriesUseCase: CategoriesUseCase):
    ViewModel() {

    val loadCategories = categoriesUseCase.loadCategories()


    fun migration(context: Context) = viewModelScope.launch {
        categoriesUseCase.startMigration(context)

    }


}