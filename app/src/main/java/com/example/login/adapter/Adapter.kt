package com.example.login.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.login.model.Attributes
import com.example.login.R

class Adapter(private val playerList: List<Attributes>) :
    RecyclerView.Adapter<Adapter.Viewholder>() {
    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        var playerName: TextView? = null
        var playerimage: ImageView? = null
        var playerspecial: TextView? = null

        init {
            this.playerName = view.findViewById(R.id.player_name)
            this.playerimage = view.findViewById(R.id.player_img)
            this.playerspecial = view.findViewById(R.id.player_spl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layouts, parent, false)
        return Viewholder(itemView)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.playerName?.text = playerList[position].playerNameApi
        Glide.with(holder.itemView.context)
            .load(playerList[position].playerImageApi)
            .into(holder.playerimage!!)
        holder.playerspecial?.text = playerList[position].playerSpecialApi
    }

    override fun getItemCount(): Int {
        return playerList.size
    }
}