package my.project.cofee.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import my.project.cofee.R
import my.project.cofee.databinding.ActivityMainBinding
import my.project.cofee.presentation.viewModels.CoffeeViewModel
import org.koin.android.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    //Подключаем датабайндинг для Main Activity
    private var binding: ActivityMainBinding? = null
//подключаем di Koin для ViewModel
    private val coffeeViewModel: CoffeeViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Указываем layout для этого активити
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//Указываем куда нужно мигрировать данные из coffeeViewModel
        coffeeViewModel.migration(this)

//Байндинг для верхнего меню
        setSupportActionBar(binding?.topMainMenu)

//Замена фрагмента main activity на наполнение из фрагмента Home
        supportFragmentManager.beginTransaction().replace(R.id.mainContent, Home()).commit()

//Обработка табов по BottomNavigation menu
        binding?.bottomMainMenu?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeBottomMainMenu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContent, Home()).commit()
                R.id.coffeeBottomMainMenu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContent, Cofee()).commit()
                R.id.cardBottomMainMenu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContent, Card()).commit()
                R.id.accountBottomMainMenu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.mainContent, Account()).commit()
            }
            return@setOnItemSelectedListener true
        }

        binding?.bottomMainMenu?.selectedItemId = R.id.homeBottomMainMenu
    }


}