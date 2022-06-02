package com.example.login.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R
import com.example.login.model.MultiViews
import com.example.login.model.WeatherInformation

class FlowsAdapter(private var weatherList: List<WeatherInformation>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.flows_api, parent, false)
        return Viewholder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
    fun updateData(weatherList: List<WeatherInformation>) {
        this.weatherList = weatherList
    }
}