package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Basicfrag : Fragment()
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

        val recyclerView=view.findViewById<RecyclerView>(R.id.RecycleList)
        var adapter = Adapter(playersdata())

        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()
        return view
    }



    private fun playersdata(): ArrayList<Names>
    {
           var result = ArrayList<Names>()
        for (i in 0..19)
        {
            var eachuser: Names = Names("Suresh Raina")
            result.add(eachuser)
        }
           return result
    }


}