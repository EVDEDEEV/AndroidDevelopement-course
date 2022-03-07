package my.project.mymvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import my.project.mymvvm.R
import my.project.mymvvm.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity :  AppCompatActivity() {

    private var binding:ActivityMainBinding? = null
    val categoriesViewModel: CategoriesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


            binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        categoriesViewModel.migration(this)
    }

}