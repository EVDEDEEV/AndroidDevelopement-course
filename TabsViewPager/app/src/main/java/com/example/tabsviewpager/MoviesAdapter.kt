package com.example.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MoviesAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                BadBoys()
            }
            1 -> {
                Avengers()
            }
            2 -> {
                Fast()
            }
            3 -> {
                Transformers()
            }
            else -> {
                BadBoys()
            }
        }
    }
}
