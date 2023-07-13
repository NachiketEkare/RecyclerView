package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class myAdapter(var newsArrayList: ArrayList<News> , var context : Activity):
    RecyclerView.Adapter<myAdapter.myViewHolder>() {


    private lateinit var myListener:onitemclicklistener

    interface onitemclicklistener{
        fun onItemclick(position: Int)
    }

    fun setitemclicklistener(listener :onitemclicklistener){
        myListener = listener
    }

    // when layout manager fails to find suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        val itemview =LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
        return myViewHolder(itemview,myListener)

    }

    // populate items with data
    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var currentItem = newsArrayList[position]
        holder.htitle.text = currentItem.newsHeading
        holder.Himage.setImageResource(currentItem.newsImage)


    }
    // how many lisitems are present in newsarray
    override fun getItemCount(): Int {

        return newsArrayList.size

    }

    // it hold the views so views are not everytime , so memory will be saved
    class myViewHolder(itemview : View,listener :onitemclicklistener): RecyclerView.ViewHolder(itemview){

        var htitle = itemview.findViewById<TextView>(R.id.TextHeading)
        var Himage = itemview.findViewById<ShapeableImageView>(R.id.TitleImage)

        init {
            itemview.setOnClickListener {
                listener.onItemclick(adapterPosition)
            }
        }
    }

}


