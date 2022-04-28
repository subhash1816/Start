package com.example.login.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.login.R
import com.example.login.adapter.ViewPagerAdapter
import com.example.login.databinding.ViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator


class ViewPager : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ViewPagerBinding =
            DataBindingUtil.inflate(inflater, R.layout.view_pager, container, false)
        binding.viewPager.adapter = ViewPagerAdapter(parentFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabView, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "HetroRecycler"
                }
                1 -> {
                    tab.text = "Favourites"
                }
                2 -> {
                    tab.text = "HomoRecycler"
                }
            }
        }.attach()
        return binding.root
    }

}