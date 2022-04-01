package com.example.login.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R
import com.example.login.adapter.Adapter
import com.example.login.model.Attributes
import com.example.login.utils.RetrofitService

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Basicfrag : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_basic_frag, container, false)
        val message = view.findViewById<TextView>(R.id.username_transfer)
        val reargs = this.arguments

        val input = reargs?.getString("Message")
        "Hii welcome $input".also { message.text = it }
        val dynamicBtn = view.findViewById<Button>(R.id.next_page)
        val pagerBtn = view.findViewById<Button>(R.id.tab_view)
        dynamicBtn.setOnClickListener {
            parentFragmentManager.beginTransaction().run {
                replace(R.id.landing_fragment, HeteroLayout())
                addToBackStack(null)
                commit()
            }
        }
        pagerBtn.setOnClickListener{
            parentFragmentManager.beginTransaction().run {
                replace(R.id.landing_fragment , ViewPager())
                addToBackStack(null)
                commit()
            }
        }

        val playerRecyclerView = view.findViewById<RecyclerView>(R.id.player_recycler)
        val url = "https://run.mocky.io/v3/"
        val rf = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
        val rfData = rf.playerlist()

        playerRecyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )

        rfData.enqueue(object : Callback<List<Attributes>?> {
            override fun onResponse(
                call: Call<List<Attributes>?>,
                response: Response<List<Attributes>?>
            ) {
                val responseBody = response.body()
                playerRecyclerView?.itemAnimator = DefaultItemAnimator()
                val myAdapter = responseBody?.let { Adapter(it) }
                playerRecyclerView?.adapter = myAdapter
            }

            override fun onFailure(call: Call<List<Attributes>?>, t: Throwable) {
                Toast.makeText(requireContext(), "Please Retry Later!!", Toast.LENGTH_SHORT).show()
            }
        })
        return view
    }
}





