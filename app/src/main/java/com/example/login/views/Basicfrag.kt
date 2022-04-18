package com.example.login.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.login.R
import com.example.login.adapter.Adapter
import com.example.login.databinding.FragmentBasicFragBinding
import com.example.login.mvvm.BasicViewModel

class Basicfrag : Fragment() {
    private var messagepassing: BasicViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var adapter: Adapter = Adapter(listOf())
        messagepassing = ViewModelProvider(this).get(BasicViewModel::class.java)
        messagepassing?.getAllPlayers()
        val binding: FragmentBasicFragBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_basic_frag, container, false)
        binding.playerRecycler.adapter = adapter

        messagepassing?.playerList?.observe(viewLifecycleOwner) {
            adapter.updateData(it)
            adapter.notifyDataSetChanged()
        }

        return binding.root
    }
}





