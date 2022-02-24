package my.project.roomrecyclerview.tabs

import android.os.Bundle
import android.view.KeyEvent
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

class TabPanel : Fragment(), View.OnClickListener, View.OnKeyListener {
    //создаем переменную байндинг для дальшнейгего создания датаБайндига фрагмента и xml шаблона
    private var binding: TabPanelBinding? = null

    //создаем переменные которые наследуются от репозиториев, вью моделями и фабриками
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
//        создаем методы для заполнения шаблона
        val categoryDao =
            Database.getInstance((context as FragmentActivity).application).categoryDao
        categoryRepository = CategoryRepository(categoryDao)
        categoryFactory = CategoryFactory(categoryRepository!!)
        categoryViewModel =
            ViewModelProvider(this, categoryFactory!!).get(CategoryViewModel::class.java)

        val productDao = Database.getInstance((context as FragmentActivity).application).productDao
        productRepository = ProductRepository(productDao)
        productFactory = ProductFactory(productRepository!!)
        productViewModel =
            ViewModelProvider(this, productFactory!!).get(ProductViewModel::class.java)

//Логика для прослушивания кнопок
//Кнопки для добавления товаров
        binding?.enterNameProduct?.setOnClickListener(this)
        binding?.enterCategoryProduct?.setOnClickListener(this)
        binding?.enterPriceProduct?.setOnClickListener(this)

//Кнопка для добавления продукта
        binding?.buttonAddProduct?.setOnClickListener(this)

//Кнопки для добавления категорий
        binding?.buttonAddCategoryClothes?.setOnClickListener(this)
        binding?.buttonAddCategoryShoes?.setOnClickListener(this)
        binding?.buttonAddCategoryAccessories?.setOnClickListener(this)

        return binding?.root
    }

//Логика для полей ввода с клавиатуры
    override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
        when (view.id) {

            R.id.enterNameProduct -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterNameProduct?.text = binding?.enterNameProduct?.text
                    binding?.enterNameProduct?.setText("")
                    return true
                }
            }

            R.id.enterCategoryProduct -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterCategoryProduct?.text = binding?.enterCategoryProduct?.text
                    binding?.enterCategoryProduct?.setText("")
                    return true
                }
            }

            R.id.enterPriceProduct -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.resEnterPriceProduct?.text = binding?.enterPriceProduct?.text
                    binding?.enterPriceProduct?.setText("")
                    return true
                }
            }
        }
    return false
    }




//Логика обработки клика по кнопкам
    override fun onClick(view: View) {
        when (view.id) {

            R.id.buttonAddCategoryClothes -> {

                categoryViewModel?.startInsert(binding?.buttonAddCategoryClothes?.text?.toString()!!)
            }

            R.id.buttonAddCategoryShoes -> {

                categoryViewModel?.startInsert(binding?.buttonAddCategoryShoes?.text?.toString()!!)
            }
            R.id.buttonAddCategoryAccessories -> {

                categoryViewModel?.startInsert(binding?.buttonAddCategoryShoes?.text?.toString()!!)
            }

            R.id.buttonAddProduct -> {

                productViewModel?.startInsert(binding?.resEnterNameProduct?.text?.toString()!!,
                    binding?.resEnterCategoryProduct?.text?.toString()!!,
                    binding?.resEnterPriceProduct?.text?.toString()!!)

                clearResEnterProduct()
            }


        }


    }

    private fun clearResEnterProduct() {
        binding?.resEnterNameProduct?.setText("")
        binding?.resEnterCategoryProduct?.setText("")
        binding?.resEnterPriceProduct?.setText("")
    }
}