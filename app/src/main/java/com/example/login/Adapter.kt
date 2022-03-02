package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.sql.RowId

class Adapter(var players : ArrayList<Names>) : RecyclerView.Adapter<Adapter.Viewholder>()
{
  class Viewholder(rowId: View) : RecyclerView.ViewHolder(rowId)
  {
     var playername: TextView? = null
      init {
          this.playername = rowId.findViewById<TextView>(R.id.cards)

      }
  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Viewholder {
      val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.layouts,parent,false)
      return Viewholder(itemView)
    }

    override fun onBindViewHolder(holder: Adapter.Viewholder, position: Int) {
      var names = players[position]
        holder?.playername?.text = names.name

    }

    override fun getItemCount(): Int {
        return players.size
    }
}