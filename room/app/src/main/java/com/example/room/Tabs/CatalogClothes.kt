package com.example.room.Tabs

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
import com.example.room.Database
import com.example.room.R
import com.example.room.Tabs.products.PanelEditProduct
import com.example.room.Tabs.products.ProductsAdapter
import com.example.room.Tabs.products.ProductsViewModel
import com.example.room.Tabs.products.ProductsViewModelFactory
import com.example.room.databinding.CatalogClothesBinding
import com.example.room.db.Products
import com.example.room.db.ProductsRepository


class CatalogClothes : Fragment() {

    private var binding: CatalogClothesBinding? = null
    private var productsRepository: ProductsRepository? = null
    private var productsViewModel: ProductsViewModel? = null
    private var productsViewModelFactory: ProductsViewModelFactory? = null
    private var productsAdapter: ProductsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.catalog_clothes, container, false)

        val productsDao =
            Database.getInstance((context as FragmentActivity).application).productsDAO
        productsRepository = ProductsRepository(productsDao)
        productsViewModelFactory = ProductsViewModelFactory(productsRepository!!)
        productsViewModel =
            ViewModelProvider(this, productsViewModelFactory!!).get(ProductsViewModel::class.java)
        initRecyclerProducts()

        return binding?.root
    }

    private fun initRecyclerProducts(){
        binding?.recyclerClothes?.layoutManager = LinearLayoutManager(context)
        productsAdapter = ProductsAdapter({products: Products ->deleteProduct(products)},
            {products:Products->editProduct(products)})
        binding?.recyclerClothes?.adapter = productsAdapter

        displayProducts()
    }

    private fun displayProducts(){
        productsViewModel?.getFilter("одежда", "5000")?.observe(viewLifecycleOwner, Observer {
            productsAdapter?.setList(it)
            productsAdapter?.notifyDataSetChanged()
        })
    }

    private fun deleteProduct(products: Products) {
        productsViewModel?.deleteProduct(products)
    }

    private fun editProduct(products: Products) {
        val panelEditProduct = PanelEditProduct()
        val parameters = Bundle()
        parameters.putString("idProduct", products.id.toString())
        parameters.putString("nameProduct", products.name)
        parameters.putString("categoryProduct", products.category)
        parameters.putString("priceProduct", products.price)
        panelEditProduct.arguments = parameters

        panelEditProduct.show((context as FragmentActivity).supportFragmentManager, "editProduct")
    }

}