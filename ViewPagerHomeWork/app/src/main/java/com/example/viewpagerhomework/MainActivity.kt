package com.example.viewpagerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.viewpager.MoviesAdapter
import com.example.viewpagerhomework.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

     private var binding:ActivityMainBinding? = null

     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)

          binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

          binding?.slider?.adapter = MoviesAdapter(this)

          val tabLayoutMediator = binding?.tabSlider?.let {
               binding?.slider?.let { it1 ->
                    TabLayoutMediator(it,
                         it1,
                         TabLayoutMediator.TabConfigurationStrategy { tab, position -> })
               }
          }
          tabLayoutMediator?.attach()

     }

}