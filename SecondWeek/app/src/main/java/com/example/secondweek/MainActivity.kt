package com.example.secondweek

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.secondweek.*
import com.example.secondweek.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var binding:ActivityMainBinding? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding?.topAppBar)


        supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()

        binding?.bottomNav?.setOnNavigationItemSelectedListener(this)
        binding?.bottomNav?.selectedItemId = R.id.homeItemBottomNav

        binding?.topAppBar?.setOnMenuItemClickListener { menuItem: MenuItem ->

            when(menuItem.itemId) {

                R.id.favoritesItemTopNav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Favorites()).commit()

                    true

                }

                R.id.settingsItemTopNav -> {
                    supportFragmentManager.beginTransaction().replace(R.id.content, Settings()).commit()

                    true

                }

                else -> false
            }

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.homeItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()
            R.id.shopItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Shop()).commit()
            R.id.deliveryItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Delivery()).commit()
            R.id.accountItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Account()).commit()
        }

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.top_menu, menu)

        return true
    }


}