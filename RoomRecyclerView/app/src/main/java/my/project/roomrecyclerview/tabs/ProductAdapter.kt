package my.project.roomrecyclerview.tabs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import my.project.roomrecyclerview.R
import my.project.roomrecyclerview.databinding.CategoryItemBinding
import my.project.roomrecyclerview.databinding.ProductItemBinding
import my.project.roomrecyclerview.models.CategoryModel
import my.project.roomrecyclerview.models.ProductModel

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    private val productsList = ArrayList<ProductModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ProductItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.category_item, parent, false)
        return ProductHolder(binding)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(productsList[position])
    }

    fun setList(products: List<ProductModel>) {
        productsList.clear()
        productsList.addAll(products)
    }

    class  ProductHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            products:ProductModel
//
        ) {

            binding.idProduct.text = products.id.toString()
            binding.nameProduct.text = products.name
            binding.categoryProduct.text = products.category
            binding.priceProduct.text = products.price


        }
    }

}