package com.example.secondweek

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.example.secondweek.databinding.MainMenuBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MainMenu : BottomSheetDialogFragment() {

    private var binding: MainMenuBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_menu, container, false)

        binding?.navigationView?.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.homeMenu -> {
                    val startHome = Intent(context, MainActivity::class.java)
                    val activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((context as FragmentActivity))
                    startActivity(startHome, activityOptionsCompat.toBundle())
                }

                R.id.shopMenu -> {

                }

                R.id.favoritesMenu -> {

                }

                R.id.accountMenu -> {

                }

                R.id.contactMenu -> {

                }

                R.id.videoMenu -> {

                }


                R.id.locationMenu -> {
                }

                R.id.settingsMenu -> {
                }

                R.id.helpMenu -> {

                }

                R.id.developerMenu -> {

                }

            }
            true
        }

        return binding?.root
    }

}