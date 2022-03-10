package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter( private val playerList : List<Attributes>) : RecyclerView.Adapter<Adapter.Viewholder>()
{
  class Viewholder(rowId: View) : RecyclerView.ViewHolder(rowId)
  {
     var playername: TextView? = null
    var playerimage : ImageView ? = null
    var playerspecial : TextView ? = null
      init
      {
          this.playername = rowId.findViewById(R.id.cards)
          this.playerimage = rowId.findViewById(R.id.imageView)
          this.playerspecial = rowId.findViewById(R.id.special)
      }

  }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
      val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layouts,parent,false)
      return Viewholder(itemView)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
     holder.playername?.text = playerList[position].Name
 //   holder.playerimage?.background = playerList[position].Image
        Glide.with(holder.itemView.context)
            .load(playerList[position].Image)
            .into(holder.playerimage!!)
        holder.playerspecial?.text = playerList[position].Special

    }

    override fun getItemCount(): Int {
        return playerList.size
    }
}