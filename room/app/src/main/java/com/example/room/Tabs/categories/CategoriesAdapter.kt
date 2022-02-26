package com.example.room.Tabs.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.databinding.CategoryItemBinding
import com.example.room.db.Categories

class CategoriesAdapter(private val deleteCategory:(Categories)->Unit,
                        private val editCategory:(Categories)->Unit): RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder>() {

    private val categoriesList = ArrayList<Categories>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CategoryItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.category_item, parent, false)
        return CategoriesHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: CategoriesHolder, position: Int) {
        holder.bind(categoriesList[position],deleteCategory, editCategory)
    }

    fun setList(categories: List<Categories>) {
        categoriesList.clear()
        categoriesList.addAll(categories)

    }


    class CategoriesHolder(val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            categories: Categories,
            deleteCategory:(Categories)->Unit,
            editCategory:(Categories)->Unit
        ) {

            binding.idCategory.text = categories.id.toString()

            binding.nameCategory.text = categories.name

            binding.editCategory.setOnClickListener(View.OnClickListener {
                editCategory(categories)

            })

            binding.deleteCategory.setOnClickListener(View.OnClickListener {
                deleteCategory(categories)
            })
        }




    }

}
