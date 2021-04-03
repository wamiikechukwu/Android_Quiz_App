package com.wamiikechukwukanu.quizapp.quizlogic

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

class QuizLogic {
    fun saveToSharedPreference(position: Int, context: Context) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("map_position", AppCompatActivity.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putInt("position", position)
        editor.apply()
        editor.commit()
    }
}