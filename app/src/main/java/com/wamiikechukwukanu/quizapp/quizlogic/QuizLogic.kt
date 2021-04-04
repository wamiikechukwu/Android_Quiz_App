package com.wamiikechukwukanu.quizapp.quizlogic

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.wamiikechukwukanu.quizapp.R

class QuizLogic(val context: Context) {

    fun saveToSharedPreference(position: Int) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("map_position", AppCompatActivity.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt("position", position)
        editor.apply()
        editor.commit()
    }

    fun getCurrentSharedPreference(): Int {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("map_position", MODE_PRIVATE)
        return sharedPreferences.getInt("position", 0)
    }

    fun getPositionMap(position: Int): Int {
        val mapArrayList = ArrayList<Int>()
        mapArrayList.add(R.drawable.algeria)
        mapArrayList.add(R.drawable.angola)
        mapArrayList.add(R.drawable.benin)
        mapArrayList.add(R.drawable.botswana)
        mapArrayList.add(R.drawable.burkina_faso)
        mapArrayList.add(R.drawable.burundi)
        mapArrayList.add(R.drawable.cameroon)
        mapArrayList.add(R.drawable.cape_verde)
        mapArrayList.add(R.drawable.chad)
        mapArrayList.add(R.drawable.comoros)
        mapArrayList.add(R.drawable.cote_d_ivoire)
        mapArrayList.add(R.drawable.djibouti)
        mapArrayList.add(R.drawable.egypt)
        mapArrayList.add(R.drawable.eritrea)
        mapArrayList.add(R.drawable.eswatini)
        mapArrayList.add(R.drawable.ethiopia)
        mapArrayList.add(R.drawable.gabon)
        mapArrayList.add(R.drawable.gambia)
        mapArrayList.add(R.drawable.ghana)
        mapArrayList.add(R.drawable.guinea)
        mapArrayList.add(R.drawable.guinea_bissau)
        mapArrayList.add(R.drawable.kenya)
        mapArrayList.add(R.drawable.lesotho)
        mapArrayList.add(R.drawable.liberia)
        mapArrayList.add(R.drawable.libya)
        mapArrayList.add(R.drawable.madagascar)
        mapArrayList.add(R.drawable.malawi)
        mapArrayList.add(R.drawable.mali)
        mapArrayList.add(R.drawable.mauritania)
        mapArrayList.add(R.drawable.mauritius)
        mapArrayList.add(R.drawable.morocco)
        mapArrayList.add(R.drawable.mozambique)
        mapArrayList.add(R.drawable.namibia)
        mapArrayList.add(R.drawable.niger)
        mapArrayList.add(R.drawable.nigeria)
        mapArrayList.add(R.drawable.reunion)
        mapArrayList.add(R.drawable.rwanda)
        mapArrayList.add(R.drawable.senegal)
        mapArrayList.add(R.drawable.seychlles)
        mapArrayList.add(R.drawable.sierra_leone)
        mapArrayList.add(R.drawable.somalia)
        mapArrayList.add(R.drawable.south_africa)
        mapArrayList.add(R.drawable.south_sudan)
        mapArrayList.add(R.drawable.sudan)
        mapArrayList.add(R.drawable.tanzania)
        mapArrayList.add(R.drawable.togo)
        mapArrayList.add(R.drawable.tunisia)
        mapArrayList.add(R.drawable.uganda)
        mapArrayList.add(R.drawable.zambia)
        mapArrayList.add(R.drawable.zimbabwe)

        return mapArrayList[position]
    }


}