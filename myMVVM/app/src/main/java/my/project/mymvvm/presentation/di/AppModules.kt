package my.project.mymvvm.presentation.di

import androidx.room.Room
import my.project.mymvvm.data.localDB.LocalDB
import my.project.mymvvm.data.repository.dataSource.CategoriesApiDataSource
import my.project.mymvvm.data.repository.dataSource.CategoriesDataSource
import my.project.mymvvm.data.repository.dataSourceIMPL.CategoriesApiDataSourceIMPL
import my.project.mymvvm.data.repository.dataSourceIMPL.CategoriesDataSourceIMPL
import my.project.mymvvm.data.repository.repository.CategoriesRepository
import my.project.mymvvm.domain.repository.CategoriesCall
import my.project.mymvvm.domain.useCase.CategoriesUseCase
import my.project.mymvvm.presentation.CategoriesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


val moduleCategories = module {

    single {
        Room.databaseBuilder(androidContext(), LocalDB::class.java,
            "localDB").build()
    }

    single { get<LocalDB>().categoriesDao }


    single<CategoriesDataSource> {
        CategoriesDataSourceIMPL(
            get()
        )
    }

    single<CategoriesApiDataSource> {
        CategoriesApiDataSourceIMPL(
            get()
        )
    }

    single<CategoriesCall> { CategoriesRepository(get(), get()) }

    single { CategoriesUseCase(get()) }

    viewModel { CategoriesViewModel(get()) }

}