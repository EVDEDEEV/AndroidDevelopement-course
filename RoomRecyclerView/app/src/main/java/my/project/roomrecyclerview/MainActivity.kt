package my.project.roomrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import my.project.roomrecyclerview.databinding.ActivityMainBinding
import my.project.roomrecyclerview.tabs.TabCategories
import my.project.roomrecyclerview.tabs.TabFilters
import my.project.roomrecyclerview.tabs.TabPanel
import my.project.roomrecyclerview.tabs.TabProducts

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.content, TabPanel()).commit()

        binding?.bottomNav?.setOnNavigationItemSelectedListener(this)
        binding?.bottomNav?.selectedItemId = R.id.panelItemBottomNav
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.panelItemBottomNav -> supportFragmentManager.beginTransaction()
                .replace(R.id.content, TabPanel()).commit()
            R.id.catalogProductsItemBottomNav -> supportFragmentManager.beginTransaction()
                .replace(R.id.content, TabProducts()).commit()
            R.id.catalogClothesItemBottomNav -> supportFragmentManager.beginTransaction()
                .replace(R.id.content, TabFilters()).commit()
            R.id.catalogCategoriesItemBottomNav -> supportFragmentManager.beginTransaction()
                .replace(R.id.content, TabCategories()).commit()
        }

        return true
    }
}






