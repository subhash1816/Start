package com.example.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Basicfrag : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.fragment_basic_frag, container, false)
        val message = view.findViewById<TextView>(R.id.Viewone)
        val reargs = this.arguments
        val input = reargs?.getString("Message")
        "Hii welcome $input".also { message.text = it }

        val hetergenous = view.findViewById<Button>(R.id.Nextpage)

        hetergenous.setOnClickListener{
            parentFragmentManager.beginTransaction().run { replace(R.id.F1,HeteroLayout())
                addToBackStack(null)
                commit()
            }


        }

        val recyclerView=view.findViewById<RecyclerView>(R.id.RecycleList)

        val url = "https://run.mocky.io/v3/"
        val rf = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
        val rfData = rf.playerlist()




        rfData.enqueue(object : Callback<List<Attributes>?>
        {
            override fun onResponse(call: Call<List<Attributes>?>, response: Response<List<Attributes>?>)
            {
               val responseBody = response.body()
                recyclerView?.itemAnimator = DefaultItemAnimator()
                val myadapter = responseBody?.let { Adapter(it) }
                // myadapter.notifyDataSetChanged()
                recyclerView?.adapter = myadapter
            }

            override fun onFailure(call: Call<List<Attributes>?>, t: Throwable)
            {

            }
        })




        return view
    }

    }





