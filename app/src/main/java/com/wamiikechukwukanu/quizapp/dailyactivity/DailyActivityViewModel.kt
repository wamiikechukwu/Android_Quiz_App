package com.wamiikechukwukanu.quizapp.dailyactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wamiikechukwukanu.quizapp.R
import com.wamiikechukwukanu.quizapp.quizlogic.QuizLogic

class DailyActivityViewModel(var context: Context, var arrayList: ArrayList<DataModel>) : RecyclerView.Adapter<DailyActivityViewModel.ViewHolder>() {

    lateinit var quizLogic: QuizLogic

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var africanMap: ImageView = itemView.findViewById(R.id.image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        OBJECT NEEDS TO BE INITIALIZE FIRST
        quizLogic = QuizLogic()

        val root = LayoutInflater.from(context).inflate(R.layout.daily_activity_model, parent, false)
        return ViewHolder(root)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(arrayList[position].title).into(holder.africanMap)
        holder.itemView.setOnClickListener {
//            SAVE TO METHOD
            quizLogic.saveToSharedPreference(position, context)
        }
    }
}

