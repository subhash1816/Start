package com.example.login.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R
import com.example.login.adapter.AdapterHetro
import com.example.login.model.MultiViews
import com.example.login.interfaces.RetrofitServicePlaces
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HeteroLayout : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hetero_layout, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.dynamic_recycler)

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )

        val url = "https://run.mocky.io/v3/"
        val rf = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitServicePlaces::class.java)

        val rfData = rf.multilist()
        rfData.enqueue(object : Callback<List<MultiViews>?> {
            override fun onResponse(
                call: Call<List<MultiViews>?>,
                response: Response<List<MultiViews>?>
            ) {
                val responseBody = response.body()
                val myAdapterTwo = responseBody?.let { AdapterHetro(it) }
                recyclerView?.adapter = myAdapterTwo
            }

            override fun onFailure(call: Call<List<MultiViews>?>, t: Throwable) {
                Toast.makeText(requireContext(), "Please Retry Later!!", Toast.LENGTH_SHORT).show()
            }
        })
        return view
    }
}





