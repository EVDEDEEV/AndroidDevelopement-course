package com.example.thirdweek

import android.annotation.SuppressLint
import android.content.DialogInterface.BUTTON_POSITIVE
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.material.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import java.lang.System.load

class MainActivity : AppCompatActivity(),View.OnClickListener {

    private var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding?.containedIconButton?.setOnClickListener(this)

    }

    @SuppressLint("ResourceAsColor")
    override fun onClick(view: View) {

        val builder = MaterialAlertDialogBuilder(this, R.style.MyDialogTheme)

            .setTitle(resources.getString(R.string.badBoys))

            .setMessage(resources.getString(R.string.messageDialog))

            .setNeutralButton(resources.getString(R.string.close)) { dialog, which ->

                loadNeutral()

            }

            .setNegativeButton(resources.getString(R.string.no)) { dialog, which ->

                loadNegative()

            }

            .setPositiveButton(resources.getString(R.string.yes)) { dialog, which ->

                loadPositive()

            }

            .show()

        builder.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor (this, R.color.black))
        builder.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor (this, R.color.black))
        builder.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(ContextCompat.getColor (this, R.color.black))

    }


    private fun loadPositive() {
        binding?.result?.text = getString(R.string.actionPositive)
    }

    private fun loadNeutral() {
        binding?.result?.text = getString(R.string.actionNeutral)
    }

    private fun loadNegative() {
        binding?.result?.text = getString(R.string.actionNegative)
    }

}