package com.wamiikechukwukanu.quizapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.wamiikechukwukanu.quizapp.model.FlagNameTable
import com.wamiikechukwukanu.quizapp.quizlogic.QuizLogic
import com.wamiikechukwukanu.quizapp.viewmodel.MapQuizActivityViewModel
import kotlinx.android.synthetic.main.activity_map_quiz.*
import java.util.*

class MapQuizActivity : AppCompatActivity() {
    //    HELPER CLASS
    lateinit var quizLogic: QuizLogic

    //    FOR THE VIEW MODEL
    private lateinit var mapQuizActivityViewModel: MapQuizActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_map_quiz)

        quizLogic = QuizLogic(this)


        // INITIALIZE THE VIEW MODEL
        mapQuizActivityViewModel = ViewModelProvider(this).get(MapQuizActivityViewModel::class.java)

        val i = quizLogic.getCurrentSharedPreference()

        getCurrentMapState(i)

//        CHECK IF THE MAP NAME HAS BEEN ADDED TO THE DATA BASE BEFORE NOW
        if (quizLogic.checkIfSavedToDataBase()) {
            insertIntoRoomDataBase()

//            SET SHARED PREF TO TRUE, BECAUSE DATABASE
            quizLogic.saveIntoDataBaseOnce(false)
        }
    }

    private fun getCurrentMapState(position: Int) {
        val positionImage = quizLogic.getPositionMap(position)
        Glide.with(this).load(positionImage).into(map_image_view)

    }

    private fun insertIntoRoomDataBase() {
        val arrayList: ArrayList<FlagNameTable> = ArrayList()
        arrayList.add(FlagNameTable(1, "p", "a", "o", "x", "l", "n", "g", "g", "o", "g", "a", "n"))
        arrayList.add(FlagNameTable(2, "b", "i", "y", "n", "n", "e", "g", "y", "v", "x", "a", "n"))
        arrayList.add(FlagNameTable(3, "p", "a", "o", "x", "l", "n", "g", "g", "o", "g", "a", "n"))
        arrayList.add(FlagNameTable(4, "p", "a", "o", "x", "l", "n", "g", "g", "o", "g", "a", "n"))
        arrayList.add(FlagNameTable(5, "p", "a", "o", "x", "l", "n", "g", "g", "o", "g", "a", "n"))
        arrayList.add(FlagNameTable(6, "p", "a", "o", "x", "l", "n", "g", "g", "o", "g", "a", "n"))
        arrayList.add(FlagNameTable(7, "p", "a", "o", "x", "l", "n", "g", "g", "o", "g", "a", "n"))
        arrayList.add(FlagNameTable(8, "p", "a", "o", "x", "l", "n", "g", "g", "o", "g", "a", "n"))
        arrayList.add(FlagNameTable(9, "z", "g", "a", "i", "r", "l", "e", "a", "y", "z", "f", "f"))


        mapQuizActivityViewModel.addFlagName(arrayList)

        Toast.makeText(this, "INSERTED", Toast.LENGTH_LONG).show()
    }
}
