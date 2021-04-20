package com.wamiikechukwukanu.quizapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.wamiikechukwukanu.quizapp.model.FlagNameTable
import com.wamiikechukwukanu.quizapp.quizlogic.QuizLogic
import com.wamiikechukwukanu.quizapp.viewmodel.FlagNameViewModel
import kotlinx.android.synthetic.main.activity_map_quiz.*

class MapQuizActivity : AppCompatActivity() {
    //    HELPER CLASS
    lateinit var quizLogic: QuizLogic

    //    FOR THE VIEW MODEL
    private lateinit var flagNameViewModel: FlagNameViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_map_quiz)

        quizLogic = QuizLogic(this)


        // INITIALIZE THE VIEW MODEL
        flagNameViewModel = ViewModelProvider(this).get(FlagNameViewModel::class.java)

        val i = quizLogic.getCurrentSharedPreference()

        getCurrentMapState(i)

//        CHECK IF THE MAP NAME HAS BEEN ADDED TO THE DATA BASE BEFORE NOW
        if (quizLogic.checkIfSavedToDataBase()) {
            insertIntoRoomDataBase()

//            SET SHARED PREF TO TRUE, BECAUSE DATABASE
            quizLogic.saveIntoDataBaseOnce(false)
        }
    }

    fun getCurrentMapState(position: Int) {
        val positionImage = quizLogic.getPositionMap(position)
        Glide.with(this).load(positionImage).into(map_image_view)

    }

    private fun insertIntoRoomDataBase() {
        val flagNames = FlagNameTable(0, "I", "T", "E",
                "I", "I", "E", "O", "Q",
                "W", "O", "P", "N")

        flagNameViewModel.addFlagName(flagNames)

        Toast.makeText(this, "INSERTED", Toast.LENGTH_LONG).show()
    }
}
