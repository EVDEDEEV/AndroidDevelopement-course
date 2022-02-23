package my.project.roomrecyclerview.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.CallbackRegistry
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import my.project.roomrecyclerview.R
import my.project.roomrecyclerview.data.Database
import my.project.roomrecyclerview.databinding.TabPanelBinding
import my.project.roomrecyclerview.repositories.CategoryRepository
import my.project.roomrecyclerview.repositories.ProductRepository
import my.project.roomrecyclerview.viewModels.CategoryFactory
import my.project.roomrecyclerview.viewModels.CategoryViewModel
import my.project.roomrecyclerview.viewModels.ProductFactory
import my.project.roomrecyclerview.viewModels.ProductViewModel

class TabPanel : Fragment() {

    private var binding:TabPanelBinding? = null
    private var categoryRepository: CategoryRepository? = null
    private var categoryViewModel: CategoryViewModel? = null
    private var categoryFactory: CategoryFactory? = null

    private var productRepository: ProductRepository? = null
    private var productViewModel: ProductViewModel? = null
    private var productFactory: ProductFactory? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.tab_panel, container, false)

        val categoryDao = Database.getInstance((context as FragmentActivity).application).categoryDao
        categoryRepository = CategoryRepository(categoryDao)
        categoryFactory = CategoryFactory(categoryRepository!!)
        categoryViewModel = ViewModelProvider(this, categoryFactory!!).get(CategoryViewModel::class.java)

        val productDao = Database.getInstance((context as FragmentActivity).application).productDao
        productRepository = ProductRepository(productDao)
        productFactory = ProductFactory(productRepository!!)
        productViewModel = ViewModelProvider(this, productFactory!!).get(ProductViewModel::class.java)




        return binding?.root
    }
}