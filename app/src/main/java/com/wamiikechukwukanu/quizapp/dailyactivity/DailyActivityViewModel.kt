package com.wamiikechukwukanu.quizapp.dailyactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wamiikechukwukanu.quizapp.R
import kotlinx.android.synthetic.main.daily_activity_model.view.*


class DailyActivityViewModel(var context: Context, var arrayList: ArrayList<DataModel>, var itemClickListener: OnItemClickListener) : RecyclerView.Adapter<DailyActivityViewModel.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var africanMap = itemView.image_view

        fun bind(user: Int, clickListener: OnItemClickListener) {
            itemView.setOnClickListener {
                clickListener.onItemClicked(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val root = LayoutInflater.from(context).inflate(R.layout.daily_activity_model, parent, false)
        return ViewHolder(root)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(arrayList[position].title).into(holder.africanMap)

        val mapItemPosition = holder.adapterPosition
        holder.bind(mapItemPosition, itemClickListener)

    }
}

interface OnItemClickListener {
    fun onItemClicked(mapPosition: Int)
}

