package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator

import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HeteroLayout : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.fragment_hetero_layout, container , false)



        val recyclerView=view.findViewById<RecyclerView>(R.id.RootHetro)

        val url= "https://run.mocky.io/v3/"
        val rf = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServiceTwo::class.java )

        val rfData = rf.multilist()

        rfData.enqueue(object : Callback<List<MultiViews>?> {
            override fun onResponse( call: Call<List<MultiViews>?>, response: Response<List<MultiViews>?>) {
                val responseBody = response.body()
                recyclerView?.itemAnimator = DefaultItemAnimator()
                val myadapter = responseBody?.let { AdapterHetro(it) }
                // myadapter.notifyDataSetChanged()
                recyclerView?.adapter = myadapter
            }

            override fun onFailure(call: Call<List<MultiViews>?>, t: Throwable) {

            }
        })



      return view
    }


}





