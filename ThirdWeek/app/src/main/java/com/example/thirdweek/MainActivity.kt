package com.example.thirdweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.thirdweek.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),View.OnKeyListener {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding?.enterCity?.setOnKeyListener(this)


    }

    override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
        when (view.id) {
            R.id.enterCity -> {
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                    binding?.result?.text = binding?.enterCity?.text
                    binding?.enterCity?.setText("")
                    return true
                }

            }
        }

        return false
    }


}