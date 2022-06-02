package com.example.login.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.login.R
import com.example.login.databinding.FlowsApiBinding
import com.example.login.mvvm.FlowsViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class FlowFragment : Fragment() {
    private var flowsCounterModel: FlowsViewModel? = null
    lateinit var binding: FlowsApiBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.flows_api, container, false)
        flowsCounterModel = ViewModelProvider(this).get(FlowsViewModel::class.java)
        binding.viewModel = flowsCounterModel


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                flowsCounterModel?.uiState?.collect {
                    it.loc?.let {location ->
                        binding.region.text = location.name.toString()
                    }
                    it.current?.let {cur ->
                        binding.temperature.text = cur.temp.toString()
                    }
                }
            }
        }
        binding.searchBox.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(location: String?): Boolean {
                if (location != null) {
                    flowsCounterModel!!.place(location)
                }
                return false
            }

            override fun onQueryTextSubmit(location: String?): Boolean {
                if (location != null) {
                    flowsCounterModel!!.place(location)
                }
                return true
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*      flowsCounterModel?.uiEvent?.observe(viewLifecycleOwner) {
                  binding.flows.text = it.toString()

              } */


    }
}



