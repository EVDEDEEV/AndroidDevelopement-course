package my.project.mymvvm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import my.project.mymvvm.R
import my.project.mymvvm.data.models.CategoriesModel
import my.project.mymvvm.databinding.CategoryItemBinding

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    private val categoriesList = ArrayList<CategoriesModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CategoryItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.category_item, parent, false)
        return CategoryHolder(binding)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.bind(categoriesList[position])
    }

    fun setList(categories: List<CategoriesModel>) {
        categoriesList.clear()
        categoriesList.addAll(categories)

    }


    class CategoryHolder(val binding: CategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            categories: CategoriesModel
        ) {

            val getImage = categories.image
            Picasso.get().load(getImage).into(binding.imageCategory)
            binding.idCategory.text = categories.id.toString()
            binding.nameCategory.text = categories.name

        }

    }

}