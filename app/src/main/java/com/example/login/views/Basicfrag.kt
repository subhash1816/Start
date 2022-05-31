package com.example.login.views

import android.os.Bundle
import android.util.Log
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
import com.example.login.mvvm.BasicViewModel.Companion.NEXTPAGE
import com.example.login.mvvm.BasicViewModel.Companion.TABLAYOUT
import com.example.login.mvvm.LoginAuthViewModel.Companion.NONE
import kotlin.concurrent.thread

class Basicfrag : Fragment() {
    private var messagepassing: BasicViewModel? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentManager = parentFragmentManager
        val adapter = Adapter(listOf())
        val reargs = this.arguments
        val input = reargs?.getString("Message")
        messagepassing = ViewModelProvider(this).get(BasicViewModel::class.java)

        val binding: FragmentBasicFragBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_basic_frag, container, false)
        binding.playerRecycler.adapter = adapter
        binding.viewmodel = messagepassing
        binding.usernameTransfer.text = "Hii Welcome $input"
        messagepassing?.playerList?.observe(viewLifecycleOwner) {
            adapter.updateData(it)
            adapter.notifyDataSetChanged()
        }
        messagepassing?.uiEvent?.observe(viewLifecycleOwner) {
            when (it) {
                NEXTPAGE -> {
                    val transaction = fragmentManager.beginTransaction()
                    val fTwo = HeteroLayout()
                    transaction.replace(R.id.landing_fragment, fTwo)
                    transaction.addToBackStack(null)
                    transaction.commit()
                    messagepassing?.uiEvent?.value = NONE
                }
                TABLAYOUT -> {
                    val transaction = fragmentManager.beginTransaction()
                    val fTwo = ViewPager()
                    transaction.replace(R.id.landing_fragment, fTwo)
                    transaction.addToBackStack(null)
                    transaction.commit()
                    messagepassing?.uiEvent?.value = NONE
                }
            }
        }
        return binding.root
    }
}





