package com.example.login.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.login.views.FavouriteFragment
import com.example.login.views.HeteroLayout
import com.example.login.views.PlayerRecyclerPager


class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                HeteroLayout()
            }
            1 -> {
                FavouriteFragment()
            }
            2 -> {
                PlayerRecyclerPager()
            }
            else -> {
                FavouriteFragment()
            }
        }
    }
}