package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class Basic_frag : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_basic_frag, container, false)
        val message = view.findViewById<TextView>(R.id.Viewone)
        val reargs = this.arguments
        val input = reargs?.getString("Message")
        message.text="Hii welcome $input"
        return view
    }








}