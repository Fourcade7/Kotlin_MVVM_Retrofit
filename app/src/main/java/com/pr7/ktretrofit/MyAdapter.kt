package com.pr7.ktretrofit

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class MyAdapter(
    val arrayList: ArrayList<PostResponse>
): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(itemview:View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if (position%2==0){
            holder.itemView.linearlay.setBackgroundColor(Color.LTGRAY)
        }else{
            holder.itemView.linearlay.setBackgroundColor(Color.WHITE)

        }
        holder.itemView.textview1.setText(arrayList.get(position).title)
    }

    override fun getItemCount(): Int {
        return  arrayList.size
    }

}