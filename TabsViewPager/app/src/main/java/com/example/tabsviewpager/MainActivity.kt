package com.example.tabsviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tabsviewpager.databinding.ActivityMainBinding
import com.example.viewpager.MoviesAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding?.slider?.adapter = MoviesAdapter(this)



        val tabLayoutMediator = binding?.tabSlider?.let {
            binding?.slider?.let { it1 ->
                TabLayoutMediator(it,
                    it1,
                    TabLayoutMediator.TabConfigurationStrategy { tab, position ->

                        when (position) {
                            0 -> {
                                tab.setIcon(R.drawable.play)
                                tab.text = getString(R.string.badBoys)
                            }
                            1 -> {
                                tab.setIcon(R.drawable.play)
                                tab.text = getString(R.string.avengers)
                            }
                            2 -> {
                                tab.setIcon(R.drawable.play)
                                tab.text = getString(R.string.fast)
                            }
                            3 -> {
                                tab.setIcon(R.drawable.play)
                                tab.text = getString(R.string.transformers)
                            }
                        }

                    })
            }
        }
        tabLayoutMediator?.attach()

    }


}