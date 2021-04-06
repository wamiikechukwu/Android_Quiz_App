package com.wamiikechukwukanu.quizapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.wamiikechukwukanu.quizapp.quizlogic.QuizLogic
import kotlinx.android.synthetic.main.activity_map_quiz.*

class MapQuizActivity : AppCompatActivity() {
    lateinit var quizLogic: QuizLogic
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quizLogic = QuizLogic(this)
        supportActionBar?.hide()
        setContentView(R.layout.activity_map_quiz)


        val i = quizLogic.getCurrentSharedPreference()
        Log.d("WAMI", i.toString())
        getCurrentMapState(i)
    }

    fun getCurrentMapState(position: Int) {
        val positionImage = quizLogic.getPositionMap(position)
        Glide.with(this).load(positionImage).into(map_image_view)

    }
}