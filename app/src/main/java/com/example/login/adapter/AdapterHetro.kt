package com.example.login.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.login.R
import com.example.login.model.MultiViews

class AdapterHetro(private var Hetrolist: List<MultiViews>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        var personName: TextView? = null
        var personMobile: TextView? = null

        init {
            this.personName = view.findViewById(R.id.name)
            this.personMobile = view.findViewById(R.id.phone)

        }
    }

    class ViewholderTwo(view: View) : RecyclerView.ViewHolder(view) {
        var spotImage: ImageView? = null

        init {
            this.spotImage = view.findViewById(R.id.places)
        }
    }

    class ViewholderThree(view: View) : RecyclerView.ViewHolder(view) {
        var hintInput: EditText? = null

        init {
            this.hintInput = view.findViewById(R.id.wishes)
        }
    }

    class ViewholderNone(view: View) : RecyclerView.ViewHolder(view) {
        var handleText: TextView? = null

        init {
            this.handleText = view.findViewById(R.id.handle_views)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (Hetrolist[position].layoutView) {
            "TextView" -> {
                R.layout.text_card
            }
            "ImageView" -> {
                R.layout.image_card
            }
            "EditText" -> {
                R.layout.rating_card
            }
            else -> {
                R.layout.no_view
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            R.layout.text_card -> {
                Viewholder(
                    LayoutInflater.from(parent.context).inflate(R.layout.text_card, parent, false)
                )
            }
            R.layout.image_card -> {
                ViewholderTwo(
                    LayoutInflater.from(parent.context).inflate(R.layout.image_card, parent, false)
                )
            }
            R.layout.rating_card -> {
                ViewholderThree(
                    LayoutInflater.from(parent.context).inflate(R.layout.rating_card, parent, false)
                )
            }
            else -> {
                ViewholderNone(
                    LayoutInflater.from(parent.context).inflate(R.layout.no_view, parent, false)
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder.itemViewType) {

            R.layout.text_card -> {
                val vh1 = holder as Viewholder
                vh1.personName?.text = Hetrolist[position].name
                vh1.personMobile?.text = Hetrolist[position].mobile

            }
            R.layout.image_card -> {
                val vh2 = holder as ViewholderTwo
                vh2.spotImage?.let {
                    Glide.with(vh2.itemView.context)
                        .load(Hetrolist[position].image)
                        .into(it)
                }

            }
            R.layout.rating_card -> {
                val vh3 = holder as ViewholderThree
                vh3.hintInput?.hint = Hetrolist[position].hint

            }
            else -> {
                val vh4 = holder as ViewholderNone
                "Unknown View Handled".also { vh4.handleText?.text = it }
            }
        }
    }

    override fun getItemCount(): Int {
        return Hetrolist.size
    }

    fun updateData(placesList: List<MultiViews>) {
        this.Hetrolist = placesList
    }

}

