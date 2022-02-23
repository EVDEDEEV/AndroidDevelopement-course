package my.project.roomrecyclerview.tabs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import my.project.roomrecyclerview.R
import my.project.roomrecyclerview.databinding.CategoryItemBinding
import my.project.roomrecyclerview.models.CategoryModel
import java.util.*
import kotlin.collections.ArrayList

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private val categoriesList = ArrayList<CategoryModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CategoryItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.category_item, parent, false)
        return CategoryHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(categoriesList[position])
    }

    fun setList(categories: List<CategoryModel>) {
        categoriesList.clear()
        categoriesList.addAll(categories)
    }

    class  CategoryHolder(val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            categories: CategoryModel,
//            deleteCategory:(TabCategories) -> Unit,
//            editCategory:(TabCategories) -> Unit
        ) {

            binding.idCategory.text = categories.id.toString()
            binding.nameCategory.text = categories.name

        }
    }

}