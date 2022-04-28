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
import com.example.login.databinding.PlayerViewpagerBinding
import com.example.login.mvvm.BasicViewModel

class PlayerRecyclerPager : Fragment() {
    private var messagepassing: BasicViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val adapter = Adapter(listOf())
        messagepassing = ViewModelProvider(this).get(BasicViewModel::class.java)
     //   messagepassing?.getAllPlayers()
        //here also we can reuse the fragment_hetro_layout.xml for recycler view
        val binding: PlayerViewpagerBinding =
            DataBindingUtil.inflate(inflater, R.layout.player_viewpager, container, false)
        binding.playerViewpagerRecycler.adapter = adapter


        messagepassing?.playerList?.observe(viewLifecycleOwner) {
            with(adapter) {
                updateData(it)
                notifyDataSetChanged()
            }
        }
        return binding.root
    }
}