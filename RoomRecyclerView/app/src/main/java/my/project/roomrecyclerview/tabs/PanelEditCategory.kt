package my.project.roomrecyclerview.tabs

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import my.project.roomrecyclerview.R
import my.project.roomrecyclerview.data.Database
import my.project.roomrecyclerview.databinding.PanelEditCategoryBinding
import my.project.roomrecyclerview.repositories.CategoryRepository
import my.project.roomrecyclerview.viewModels.CategoryFactory
import my.project.roomrecyclerview.viewModels.CategoryViewModel


class PanelEditCategory  : BottomSheetDialogFragment(), View.OnKeyListener {

    private var binding: PanelEditCategoryBinding? = null
    private var categoryRepository: CategoryRepository? = null
    private var categoryViewModel: CategoryViewModel? = null
    private var factory: CategoryFactory? = null
    private var idCategory: Int? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.panel_edit_category, container,false)

        idCategory = arguments?.getString("idCategory")?.toInt()
        binding?.editCategory?.setText(arguments?.getString("nameCategory").toString())

        val categoryDao = Database.getInstance((context as FragmentActivity).application).categoryDao
        categoryRepository = CategoryRepository(categoryDao)
        factory = CategoryFactory(categoryRepository!!)
        categoryViewModel = ViewModelProvider(this, factory!!).get(CategoryViewModel::class.java)

        binding?.editCategory?.setOnKeyListener(this)
        return inflater.inflate(R.layout.panel_edit_category, container, false)
    }

    override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
        when (view.id) {

            R.id.editCategory -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    categoryViewModel?.startUpdateProduct(idCategory.toString().toInt(), binding?.editCategory?.text?.toString()!!)

                    binding?.editCategory?.setText("")

                    dismiss()

                    (context as FragmentActivity).supportFragmentManager.beginTransaction().replace(R.id.content, TabCategories()).commit()

                    return true
                }

            }
        }
        return false
    }

}