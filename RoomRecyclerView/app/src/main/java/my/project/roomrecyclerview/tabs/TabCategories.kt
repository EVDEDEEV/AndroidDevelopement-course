package my.project.roomrecyclerview.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import my.project.roomrecyclerview.R
import my.project.roomrecyclerview.databinding.TabCategoriesBinding
import my.project.roomrecyclerview.repositories.CategoryRepository
import my.project.roomrecyclerview.viewModels.CategoryViewModel

class TabCategories : Fragment() {

    private var binding: TabCategoriesBinding? = null
    private var categoriesRepository: CategoryRepository? = null
    private var categoriesViewModel: CategoryViewModel? = null
    private var categoryAdapter: CategoryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.tab_categories, container, false)

        return binding?.root

    }
}