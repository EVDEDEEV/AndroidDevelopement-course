package my.project.mymvvm.data.api

import my.project.mymvvm.data.models.CategoriesApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("loadCategories.php")
    fun loadCategoriesApi(): Call<ArrayList<CategoriesApiModel>>
}