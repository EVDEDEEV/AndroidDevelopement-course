package com.example.secondweek

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.secondweek.*
import com.example.secondweek.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

            //байндинг для materialView
        binding?.buttonMovie?.setOnClickListener(this)
            //^

        supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()

        binding?.bottomNav?.setOnNavigationItemSelectedListener { item ->

            when(item.itemId) {
                R.id.homeItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Home()).commit()
                R.id.shopItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Shop()).commit()
                R.id.deliveryItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Delivery()).commit()
                R.id.accountItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content, Account()).commit()
            }

            return@setOnNavigationItemSelectedListener true


        }
        binding?.bottomNav?.selectedItemId = R.id.homeItemBottomNav
    }
    //Для нижнего выезжающего окна с информацией
    override fun onClick(view: View) {

        val details = Details()

        val parameters = Bundle()

        parameters.putString("nameMovie", binding?.nameMovie?.text?.toString())
        parameters.putString("longMovie", binding?.longMovie?.text?.toString())
        parameters.putString("actorsMovie", binding?.actorsMovie?.text?.toString())

        details.arguments = parameters

        details.show(supportFragmentManager, "details")

    }
        //^
}




