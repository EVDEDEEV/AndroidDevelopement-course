package my.project.roomrecyclerview.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import my.project.roomrecyclerview.R
import my.project.roomrecyclerview.data.Database
import my.project.roomrecyclerview.data.ProductDao
import my.project.roomrecyclerview.databinding.TabCategoriesBinding
import my.project.roomrecyclerview.databinding.TabProductsBinding
import my.project.roomrecyclerview.repositories.CategoryRepository
import my.project.roomrecyclerview.repositories.ProductRepository
import my.project.roomrecyclerview.viewModels.CategoryFactory
import my.project.roomrecyclerview.viewModels.CategoryViewModel
import my.project.roomrecyclerview.viewModels.ProductFactory
import my.project.roomrecyclerview.viewModels.ProductViewModel


class TabProducts: Fragment() {

    private var binding: TabProductsBinding? = null
    private var productRepository: ProductRepository? = null
    private var productViewModel: ProductViewModel? = null
    private var productFactory: ProductFactory? = null
    private var productAdapter: ProductAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.tab_products, container, false)

        val productDao = Database.getInstance((context as FragmentActivity).application).productDao
        productRepository = ProductRepository(productDao)
        productFactory = ProductFactory(productRepository!!)
        productViewModel = ViewModelProvider(this, productFactory!!).get(ProductViewModel::class.java)

        initRecyclerProducts()
        displayProducts()

        binding?.deleteAllProducts?.setOnClickListener(View.OnClickListener {
            productViewModel?.deleteAllProducts()
        })

        return binding?.root

    }

    private fun initRecyclerProducts() {
        binding?.recyclerProducts?.layoutManager = LinearLayoutManager(context)
        productAdapter = ProductAdapter()
        binding?.recyclerProducts?.adapter = productAdapter

    }

    private fun displayProducts(){
        productViewModel?.products?.observe(viewLifecycleOwner, Observer {
            productAdapter?.setList(it)
            productAdapter?.notifyDataSetChanged()
        })
    }
}