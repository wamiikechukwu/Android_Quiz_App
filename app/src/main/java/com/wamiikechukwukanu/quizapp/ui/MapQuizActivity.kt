package com.wamiikechukwukanu.quizapp.ui

import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.wamiikechukwukanu.quizapp.R
import com.wamiikechukwukanu.quizapp.db.Database
import com.wamiikechukwukanu.quizapp.quizlogic.QuizLogic
import kotlinx.android.synthetic.main.activity_intro_start_quiz.view.*
import kotlinx.android.synthetic.main.activity_map_quiz.*

class MapQuizActivity : AppCompatActivity() {
    //    HELPER CLASS
    lateinit var quizLogic: QuizLogic
    lateinit var database: Database
    lateinit var cursor: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_map_quiz)

        quizLogic = QuizLogic(this)
        database = Database(applicationContext)

        val currentMapPosition = quizLogic.getCurrentSharedPreference()

        quizLogic.setButtons(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)

//        SET THE LETTERS TO THE LOWER BUTTONS
        getCurrentRowFromDatabase(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)

        getCurrentMapState(currentMapPosition)

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
        database.insertFlagNameIntoDataBase("z", "g", "a", "i", "r", "l", "e", "a", "y", "z", "f", "f")
        database.insertFlagNameIntoDataBase("p", "a", "o", "x", "l", "n", "g", "g", "o", "g", "a", "n")
        database.insertFlagNameIntoDataBase("b", "i", "y", "n", "n", "e", "g", "y", "v", "x", "a", "n")
        database.insertFlagNameIntoDataBase("m", "o", "s", "t", "e", "a", "b", "w", "n", "w", "a", "k")
        database.insertFlagNameIntoDataBase("m", "o", "s", "t", "e", "a", "b", "w", "n", "w", "a", "k")
        database.insertFlagNameIntoDataBase("u", "m", "r", "u", "e", "n", "b", "i", "s", "d", "o", "s")
        database.insertFlagNameIntoDataBase("a", "r", "m", "o", "c", "t", "m", "o", "n", "n", "r", "e")
        database.insertFlagNameIntoDataBase("c", "e", "e", "e", "a", "h", "r", "v", "q", "d", "q", "p")
        database.insertFlagNameIntoDataBase("z", "r", "i", "d", "p", "h", "c", "j", "b", "l", "y", "a")
        database.insertFlagNameIntoDataBase("o", "d", "r", "z", "k", "m", "o", "o", "j", "o", "c", "s")
        database.insertFlagNameIntoDataBase("o", "v", "d", "i", "w", "c", "t", "o", "e", "e", "r", "i")
        database.insertFlagNameIntoDataBase("t", "l", "r", "b", "o", "i", "u", "j", "d", "i", "m", "b")
        database.insertFlagNameIntoDataBase("o", "p", "y", "t", "a", "y", "s", "e", "y", "g", "b", "j")
        database.insertFlagNameIntoDataBase("r", "m", "e", "e", "r", "l", "c", "x", "t", "a", "j", "i")
        database.insertFlagNameIntoDataBase("w", "w", "e", "t", "l", "s", "v", "i", "a", "n", "i", "g")
        database.insertFlagNameIntoDataBase("i", "i", "p", "f", "o", "s", "t", "a", "h", "e", "j", "t")
        database.insertFlagNameIntoDataBase("y", "x", "n", "k", "y", "t", "f", "a", "o", "g", "b", "f")
        database.insertFlagNameIntoDataBase("c", "u", "i", "b", "a", "m", "w", "a", "t", "d", "p", "g")
        database.insertFlagNameIntoDataBase("u", "n", "a", "g", "j", "a", "t", "h", "a", "x", "h", "x")
        database.insertFlagNameIntoDataBase("b", "a", "b", "u", "r", "e", "n", "g", "s", "s", "i", "u")
        database.insertFlagNameIntoDataBase("a", "n", "s", "s", "u", "u", "g", "e", "b", "i", "i", "a")
        database.insertFlagNameIntoDataBase("p", "r", "a", "b", "f", "e", "k", "y", "n", "x", "q", "r")
        database.insertFlagNameIntoDataBase("s", "t", "e", "e", "l", "m", "o", "h", "n", "w", "y", "o")
        database.insertFlagNameIntoDataBase("e", "b", "a", "r", "e", "c", "i", "s", "i", "m", "l", "r")
        database.insertFlagNameIntoDataBase("a", "r", "l", "t", "b", "a", "a", "y", "l", "m", "n", "i")
        database.insertFlagNameIntoDataBase("r", "a", "s", "y", "g", "c", "a", "a", "m", "d", "w", "a")
        database.insertFlagNameIntoDataBase("t", "d", "a", "m", "i", "w", "l", "m", "z", "w", "q", "a")
        database.insertFlagNameIntoDataBase("b", "i", "m", "d", "j", "n", "d", "a", "l", "c", "j", "m")
        database.insertFlagNameIntoDataBase("z", "t", "r", "n", "i", "a", "a", "n", "i", "m", "u", "a")
        database.insertFlagNameIntoDataBase("r", "m", "i", "u", "i", "b", "s", "t", "u", "a", "l", "y")
        database.insertFlagNameIntoDataBase("o", "c", "r", "m", "c", "c", "e", "l", "h", "x", "o", "o")
        database.insertFlagNameIntoDataBase("o", "z", "c", "i", "b", "w", "u", "m", "q", "e", "m", "a")
        database.insertFlagNameIntoDataBase("i", "n", "w", "m", "b", "i", "i", "a", "x", "a", "n", "x")
        database.insertFlagNameIntoDataBase("p", "v", "i", "r", "m", "h", "n", "e", "s", "g", "q", "d")
        database.insertFlagNameIntoDataBase("i", "i", "n", "g", "u", "w", "e", "a", "j", "v", "u", "r")
        database.insertFlagNameIntoDataBase("o", "r", "e", "n", "y", "e", "i", "s", "i", "n", "u", "r")
        database.insertFlagNameIntoDataBase("a", "a", "s", "t", "q", "d", "k", "r", "n", "w", "w", "v")
        database.insertFlagNameIntoDataBase("s", "e", "l", "n", "e", "y", "j", "g", "a", "w", "s", "y")
        database.insertFlagNameIntoDataBase("l", "e", "s", "e", "c", "s", "t", "y", "l", "h", "d", "y")
        database.insertFlagNameIntoDataBase("l", "i", "n", "e", "r", "r", "e", "e", "p", "o", "a", "s")
        database.insertFlagNameIntoDataBase("r", "r", "s", "j", "l", "z", "m", "o", "a", "i", "c", "a")
        database.insertFlagNameIntoDataBase("s", "f", "u", "o", "a", "h", "r", "b", "t", "a", "i", "c")
        database.insertFlagNameIntoDataBase("h", "s", "n", "s", "o", "d", "t", "a", "t", "u", "z", "u")
        database.insertFlagNameIntoDataBase("s", "z", "a", "i", "k", "p", "u", "f", "c", "n", "d", "n")
        database.insertFlagNameIntoDataBase("z", "a", "a", "l", "r", "z", "a", "n", "i", "n", "a", "t")
        database.insertFlagNameIntoDataBase("g", "a", "o", "o", "t", "u", "n", "u", "j", "g", "d", "f")
        database.insertFlagNameIntoDataBase("i", "d", "a", "t", "b", "u", "w", "t", "s", "n", "s", "i")
        database.insertFlagNameIntoDataBase("g", "p", "e", "n", "e", "t", "a", "a", "g", "u", "d", "z")
        database.insertFlagNameIntoDataBase("a", "x", "h", "w", "b", "i", "s", "z", "i", "a", "m", "d")
        database.insertFlagNameIntoDataBase("a", "b", "z", "o", "a", "w", "i", "m", "e", "u", "b", "m")

    }

    private fun getCurrentRowFromDatabase(position: Int, firstBtn: Button, secondBtn: Button, thirdBtn: View, fourthBtn: View, fifthBtn: View, sixthBtn: View,
                                          seventhBtn: View, eighthBtn: View, ninthBtn: View, tenthBtn: View, eleventhBtn: View, twelfthBbn: View){
        cursor = database.getFlagNameByIndex(position)
                if (cursor.count == 0){
                    //TODO add a AlertDialog
                    Toast.makeText(this,"this database row for $position is empty",Toast.LENGTH_LONG).show()
                }else{
                    while (cursor.moveToNext()){
                        firstBtn.text = cursor.getString(0).toString()
                        secondBtn.text = cursor.getString(1).toString()
                    }
                }
    }


}
