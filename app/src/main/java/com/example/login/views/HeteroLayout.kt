package com.example.login.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.login.R
import com.example.login.adapter.AdapterHetro
import com.example.login.databinding.FragmentHeteroLayoutBinding
import com.example.login.mvvm.DynamicViewsViewModel
import kotlinx.coroutines.launch


class HeteroLayout : Fragment() {
   // private var dynamicApiViews: DynamicViewsViewModel? = null
    private  var dynamicApiViews = DynamicViewsViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val dynamicAdapter = AdapterHetro(listOf())
        val binding: FragmentHeteroLayoutBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_hetero_layout, container, false)
        dynamicApiViews = ViewModelProvider(this).get(DynamicViewsViewModel::class.java)

        binding.dynamicRecycler.adapter = dynamicAdapter

        dynamicApiViews.dynamicViews.observe(viewLifecycleOwner) {
            dynamicAdapter.updateData(it)
            dynamicAdapter.notifyDataSetChanged()
        }

        return binding.root
    }
}





