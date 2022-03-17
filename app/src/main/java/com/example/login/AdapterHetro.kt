package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterHetro(private val Hetrolist: List<MultiViews>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    class Viewholder(rowId: View) : RecyclerView.ViewHolder(rowId) {
        var name: TextView? = null
        var mobile: TextView? = null


        init {
            this.name = rowId.findViewById(R.id.name)
            this.mobile = rowId.findViewById(R.id.phone)

        }

    }
    class ViewholderTwo(rowId: View) : RecyclerView.ViewHolder(rowId)
    {
       var spotimage: ImageView? = null

        init
        {
            this.spotimage = rowId.findViewById(R.id.places)
        }
    }
    class ViewholderThree(rowId: View) : RecyclerView.ViewHolder(rowId)
    {
        var hintInput: EditText? = null


        init
        {
            this.hintInput = rowId.findViewById(R.id.wishes)
        }
    }

    override fun getItemViewType(position: Int): Int
    {
        return when (Hetrolist[position].View)
        {
            "TextView" -> {
                R.layout.textcard
            }
            "ImageView" -> {
                R.layout.image_card
            }
            else -> {
                R.layout.ratingcard
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {

        return when (viewType)
        {
            R.layout.textcard ->{
                         Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.textcard,parent,false))
            }
            R.layout.image_card -> {
                ViewholderTwo(LayoutInflater.from(parent.context).inflate(R.layout.image_card,parent,false))
            }
            else -> {
                ViewholderThree(LayoutInflater.from(parent.context).inflate(R.layout.ratingcard,parent,false))
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder.itemViewType)
        {

            R.layout.textcard -> {
                val vh1 = holder as Viewholder
             vh1.name?.text = Hetrolist[position].Name
              vh1.mobile?.text = Hetrolist[position].Mobile

            }
            R.layout.image_card -> {
                val vh2 =  holder as ViewholderTwo
                vh2.spotimage?.let {
                    Glide.with(vh2.itemView.context)
                        .load(Hetrolist[position].Image)
                        .into(it)
                }

            }
            R.layout.ratingcard -> {
                val vh3 = holder as ViewholderThree
                vh3.hintInput?.hint = Hetrolist[position].Hint

            }

        }




    }



    override fun getItemCount(): Int {
        return Hetrolist.size
    }

}

