package com.wamiikechukwukanu.quizapp.quizlogic

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

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
}