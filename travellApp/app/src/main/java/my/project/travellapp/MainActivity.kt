package my.project.travellapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomnavigation.BottomNavigationView
import my.project.travellapp.databinding.ActivityMainBinding
import my.project.travellapp.presentation.tabs.Description
import my.project.travellapp.presentation.tabs.TourList


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding?.bottomMainMenu?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeBottomMainMenu ->
                    supportFragmentManager.beginTransaction().replace(R.id.mainContent, TourList())
                        .commit()
                R.id.descriptionBottomMainMenu ->
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mainContent, Description()).commit()
            }

            return@setOnItemSelectedListener true
        }

        binding?.bottomMainMenu?.selectedItemId = R.id.homeBottomMainMenu

    }
}
