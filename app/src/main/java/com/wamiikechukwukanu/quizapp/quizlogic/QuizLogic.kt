package com.wamiikechukwukanu.quizapp.quizlogic

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.DialogInterface
import android.content.SharedPreferences
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.getDrawable
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.gurutouchlabs.kenneth.elegantdialog.ElegantActionListeners
import com.gurutouchlabs.kenneth.elegantdialog.ElegantDialog
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

    fun saveIntoDataBaseOnce(inserted: Boolean) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("isItInsertedToDataBase", AppCompatActivity.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean("inserted", inserted)
        editor.apply()
        editor.commit()
    }

    fun checkIfSavedToDataBase(): Boolean {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences("isItInsertedToDataBase", MODE_PRIVATE)
        return sharedPreferences.getBoolean("inserted", true)
    }

    fun setButtons(position: Int, firstBtn: View, secondBtn: View, thirdBtn: View, fourthBtn: View, fifthBtn: View, sixthBtn: View,
                   seventhBtn: View, eighthBtn: View, ninthBtn: View, tenthBtn: View, eleventhBtn: View, twelfthBbn: View) {


        fun fourLetters() {
            fifthBtn.visibility = View.INVISIBLE
            sixthBtn.visibility = View.INVISIBLE
            seventhBtn.visibility = View.INVISIBLE
            eighthBtn.visibility = View.INVISIBLE
            ninthBtn.visibility = View.INVISIBLE
            tenthBtn.visibility = View.INVISIBLE
            eleventhBtn.visibility = View.INVISIBLE
            twelfthBbn.visibility = View.INVISIBLE
        }

        fun fiveLetters() {
            sixthBtn.visibility = View.INVISIBLE
            seventhBtn.visibility = View.INVISIBLE
            eighthBtn.visibility = View.INVISIBLE
            ninthBtn.visibility = View.INVISIBLE
            tenthBtn.visibility = View.INVISIBLE
            eleventhBtn.visibility = View.INVISIBLE
            twelfthBbn.visibility = View.INVISIBLE
        }

        fun sixLetters() {
            seventhBtn.visibility = View.INVISIBLE
            eighthBtn.visibility = View.INVISIBLE
            ninthBtn.visibility = View.INVISIBLE
            tenthBtn.visibility = View.INVISIBLE
            eleventhBtn.visibility = View.INVISIBLE
            twelfthBbn.visibility = View.INVISIBLE
        }

        fun sevenLetters() {
            eighthBtn.visibility = View.INVISIBLE
            ninthBtn.visibility = View.INVISIBLE
            tenthBtn.visibility = View.INVISIBLE
            eleventhBtn.visibility = View.INVISIBLE
            twelfthBbn.visibility = View.INVISIBLE
        }

        fun eightLetters() {
            ninthBtn.visibility = View.INVISIBLE
            tenthBtn.visibility = View.INVISIBLE
            eleventhBtn.visibility = View.INVISIBLE
            twelfthBbn.visibility = View.INVISIBLE
        }

        fun nineLetters() {
            tenthBtn.visibility = View.INVISIBLE
            eleventhBtn.visibility = View.INVISIBLE
            twelfthBbn.visibility = View.INVISIBLE
        }

        fun tenLetters() {
            eleventhBtn.visibility = View.INVISIBLE
            twelfthBbn.visibility = View.INVISIBLE
        }

        fun elevenLetters() {
            twelfthBbn.visibility = View.INVISIBLE

        }

        if (firstBtn.visibility == View.VISIBLE && secondBtn.visibility == View.VISIBLE &&
                thirdBtn.visibility == View.VISIBLE && fourthBtn.visibility == View.VISIBLE &&
                fifthBtn.visibility == View.VISIBLE && sixthBtn.visibility == View.VISIBLE &&
                seventhBtn.visibility == View.VISIBLE && eighthBtn.visibility == View.VISIBLE &&
                ninthBtn.visibility == View.VISIBLE && tenthBtn.visibility == View.VISIBLE &&
                eleventhBtn.visibility == View.VISIBLE && twelfthBbn.visibility == View.VISIBLE) {

            when (position) {
                /*TODO
                * ADD BUTTON BACKGROUND COLOR*/

                0 -> //algeria 7 letters
                {
                    sevenLetters()
                }
                1 -> //angola  6 letters
                {
                    sixLetters()
                }
                2 -> //benin 5 letters
                {
                    fiveLetters()
                }
                3 ->//botswana 8 letters
                {
                    eightLetters()
                }
                4 ->//burkinafaso 11 letter + 1 space
                {
                    seventhBtn.isEnabled = false
                    seventhBtn.isClickable = false
                    seventhBtn.visibility = View.INVISIBLE
                }
                5 ->//burundi 7 letters
                {
                    sevenLetters()
                }
                6 -> //cameroon 8 letters
                {
                    eightLetters()
                }
                7 -> //cape_verde 9 letters
                {
                    tenLetters()
                    fifthBtn.isEnabled = false
                    fifthBtn.isClickable = false
                    fifthBtn.visibility = View.INVISIBLE
                }
                8 -> //chad 4 letters
                {
                    fourLetters()
                }
                9 -> //comoros 7 letters
                {
                    sevenLetters()
                }
                10 -> //cote_divoire 11 letters + 1 space
                {
                    elevenLetters()
                    fifthBtn.isEnabled = false
                    fifthBtn.isClickable = false
                    fifthBtn.visibility = View.INVISIBLE
                }
                11 -> //djibouti 8 letters
                {
                    eightLetters()
                }
                12 -> //egypt 5 letters
                {
                    fiveLetters()
                }
                13 ->//eritrea 7 letters
                {
                    sevenLetters()
                }
                14 ->  //eswatini 8 letters
                {
                    eightLetters()
                }
                15 -> //ethiopia 8 letters
                {
                    eightLetters()
                }
                16 -> //gabon 5 letters
                {
                    fiveLetters()
                }
                17 -> //gambia 6 letters
                {
                    sixLetters()
                }
                18 -> //ghana 5 letters
                {
                    fiveLetters()
                }
                19 -> //guinea 6 letters
                {
                    sixLetters()
                }
                20 -> //guineabissau 12 letters NO BUTTON TO HIDE
                {

                }
                21 -> //kenya 5 letters
                {
                    fiveLetters()
                }
                22 ->//lesotho 7 letters
                {
                    sevenLetters()
                }
                23 ->//liberia 7 letters
                {
                    sevenLetters()
                }
                24 ->//libya 5 letters
                {
                    fiveLetters()
                }
                25 ->//madagascar 10 letters
                {
                    tenLetters()
                }
                26 ->//malawi 6 letters
                {
                    sixLetters()
                }
                27 ->//mali 4 letters
                {
                    fourLetters()
                }
                28 ->//mauritania 10 letters
                {
                    tenLetters()
                }
                29 -> //mauritius 9 letters
                {
                    nineLetters()
                }
                30 -> //morocco 7 letters
                {
                    sevenLetters()
                }
                31 ->//mozambique 10 letters
                {
                    tenLetters()
                }
                32 -> //namibia 7 letters
                {
                    sevenLetters()
                }
                33 -> //niger 5 letters
                {
                    fiveLetters()
                }
                34 -> //nigeria 7 letters
                {
                    sevenLetters()
                }
                35 -> //reunion 7 letters
                {
                    sevenLetters()
                }
                36 -> //rwanda 6 letters
                {
                    sixLetters()
                }
                37 -> //senegal 7 letters
                {
                    sevenLetters()
                }
                38 -> //seychlles 9 letters
                {
                    nineLetters()
                }
                39 -> //sierra_leone 11 letters + 1 space
                {
                    seventhBtn.isEnabled = false
                    seventhBtn.isClickable = false
                    seventhBtn.visibility = View.INVISIBLE
                }
                40 -> //somalia 7 letters
                {
                    sevenLetters()
                }
                41 ->//south_africa 11 letters + 1 space
                {
                    sixthBtn.isEnabled = false
                    sixthBtn.isClickable = false
                    sixthBtn.visibility = View.INVISIBLE
                }
                42 ->//south_sudan 10 letters + 1 space
                {
                    sixthBtn.isEnabled = false
                    sixthBtn.isClickable = false
                    sixthBtn.visibility = View.INVISIBLE
                }
                43 ->//sudan 5 letters
                {
                    fiveLetters()
                }
                44 ->//tanzania 8 letters
                {
                    eightLetters()
                }
                45 ->//togo 4 letters
                {
                    fourLetters()
                }
                46 ->//tunisia 7 letters
                {
                    sevenLetters()
                }
                47 ->//uganda 6 letters
                {
                    sixLetters()
                }
                48 ->//zambia 6 letters
                {
                    sixLetters()
                }
                49 ->//zimbabwe 8 letters
                {
                    eightLetters()
                }
                else ->//IN CASE
                {
                }
            }
        }


    }

    fun getTextFromButtonPressed(btnPressed: Button): CharSequence {
        return btnPressed.text
    }

    fun setTextFromButtonPressed(char: CharSequence, firstBtn: Button, secondBtn: Button, thirdBtn: Button, fourthBtn: Button, fifthBtn: Button, sixthBtn: Button,
                                 seventhBtn: Button, eighthBtn: Button, ninthBtn: Button, tenthBtn: Button, eleventhBtn: Button, twelfthBbn: Button) {

        when {
            firstBtn.text.isBlank() -> {
                firstBtn.text = char
            }
            secondBtn.text.isBlank() -> {
                secondBtn.text = char
            }
            thirdBtn.text.isBlank() -> {
                thirdBtn.text = char
            }
            fourthBtn.text.isBlank() -> {
                fourthBtn.text = char
            }
            fifthBtn.text.isBlank() -> {
                fifthBtn.text = char
            }
            sixthBtn.text.isBlank() -> {
                sixthBtn.text = char
            }
            seventhBtn.text.isBlank() -> {
                seventhBtn.text = char
            }
            eighthBtn.text.isBlank() -> {
                eighthBtn.text = char
            }
            ninthBtn.text.isBlank() -> {
                ninthBtn.text = char
            }
            tenthBtn.text.isBlank() -> {
                tenthBtn.text = char
            }
            eleventhBtn.text.isBlank() -> {
                eleventhBtn.text = char
            }
            twelfthBbn.text.isBlank() -> {
                twelfthBbn.text = char
            }
            else -> {
            }
        }
    }

    fun checkCorrectFlagName(position: Int, firstBtn: Button, secondBtn: Button, thirdBtn: Button, fourthBtn: Button, fifthBtn: Button, sixthBtn: Button,
                             seventhBtn: Button, eighthBtn: Button, ninthBtn: Button, tenthBtn: Button, eleventhBtn: Button, twelfthBbn: Button) {
        when (position) {

            0 -> {
                val correctFlagName = " algeria"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            1 -> {
                val correctFlagName = " angola"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            2 -> {
                val correctFlagName = " benin"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            3 -> {
                val correctFlagName = " botswana"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            4 -> {
                val correctFlagName = " burkinafaso"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + ninthBtn.text + tenthBtn.text + eleventhBtn.text + twelfthBbn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            5 -> {
                val correctFlagName = " burundi"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            6 -> {
                val correctFlagName = " cameroon"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            7 -> {
                val correctFlagName = " capeverde"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text + ninthBtn.text + tenthBtn
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            8 -> {
                val correctFlagName = " chad"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            9 -> {
                val correctFlagName = " comoros"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            10 -> {
                val correctFlagName = " cotedivoire"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + sixthBtn.text + eighthBtn.text + ninthBtn.text + tenthBtn.text + eleventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            11 -> {
                val correctFlagName = " djibouti"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            12 -> {
                val correctFlagName = " egypt"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            13 -> {
                val correctFlagName = " eritrea"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            14 -> {
                val correctFlagName = " eswatini"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            15 -> {
                val correctFlagName = " ethiopia"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            16 -> {
                val correctFlagName = " gabon"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            17 -> {
                val correctFlagName = " gambia"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            18 -> {
                val correctFlagName = " ghana"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            19 -> {
                val correctFlagName = " guinea"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            20 -> {
                val correctFlagName = " guineabissau"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + eighthBtn.text + ninthBtn.text + tenthBtn.text + eighthBtn.text + twelfthBbn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            21 -> {
                val correctFlagName = " kenya"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            22 -> {
                val correctFlagName = " lesotho"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            23 -> {
                val correctFlagName = " liberia"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            24 -> {
                val correctFlagName = " libya"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            25 -> {
                val correctFlagName = " madagascar"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text + ninthBtn.text + tenthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            26 -> {
                val correctFlagName = " malawi"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            27 -> {
                val correctFlagName = " mali"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            28 -> {
                val correctFlagName = " mauritania"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text + ninthBtn.text + tenthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            29 -> {
                val correctFlagName = " mauritius"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text + ninthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            30 -> {
                val correctFlagName = " morocco"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            31 -> {
                val correctFlagName = " mozambique"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text + tenthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            32 -> {
                val correctFlagName = " namibia"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            33 -> {
                val correctFlagName = " niger"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            34 -> {
                val correctFlagName = " nigeria"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            35 -> {
                val correctFlagName = " reunion"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            36 -> {
                val correctFlagName = " rwanda"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            37 -> {
                val correctFlagName = " senegal"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            38 -> {
                val correctFlagName = " seychlles"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text + ninthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            39 -> {
                val correctFlagName = " sierraleone"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + eighthBtn.text + ninthBtn.text + tenthBtn.text + eleventhBtn.text + twelfthBbn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            40 -> {
                val correctFlagName = " somalia"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            41 -> {
                val correctFlagName = " southafrica"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + seventhBtn.text + eighthBtn.text + ninthBtn.text + tenthBtn.text + eleventhBtn.text + twelfthBbn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            42 -> {
                val correctFlagName = " southsudan"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + seventhBtn.text + eighthBtn.text + ninthBtn.text + tenthBtn.text + eleventhBtn.text + twelfthBbn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            43 -> {
                val correctFlagName = " sudan"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            44 -> {
                val correctFlagName = " tanzania"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            45 -> {
                val correctFlagName = " togo"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            46 -> {
                val correctFlagName = " tunisia"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            47 -> {
                val correctFlagName = " uganda"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            48 -> {
                val correctFlagName = " zambia"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }
            49 -> {
                val correctFlagName = " zimbabwe"
                val userOwnNameForTheFlag = " " + firstBtn.text + secondBtn.text + thirdBtn.text + fourthBtn.text + fifthBtn.text + sixthBtn.text + seventhBtn.text + eighthBtn.text
                if (correctFlagName.equals(userOwnNameForTheFlag, true)) {
                    showAlertDialog(context, "CORRECT")
                }
            }


            else -> {

            }
        }
    }

    fun showAlertDialog(context: Context, msg: String) {
        // Create Alert
        val alertDialog = ElegantDialog(context)
                .setCornerRadius(10.0f)
                .setCanceledOnTouchOutside(true)
                .setTitleHidden(false)
                .setBackgroundTopColor(getColor(context, R.color.browser_actions_bg_grey))// Set top color
                .setBackgroundBottomColor(getColor(context, R.color.md_white_1000)) // Set bottom color
                .setElegantActionClickListener(object : ElegantActionListeners {
                    override fun onCancelListener(dialog: DialogInterface) {
                    }

                    override fun onGotItListener(dialog: ElegantDialog) {
                        dialog.dismiss()
                    }

                    override fun onNegativeListener(dialog: ElegantDialog) {
                        dialog.dismiss()
                    }

                    override fun onPositiveListener(dialog: ElegantDialog) {
                        var mInterstitialAd: InterstitialAd? = null
                        MobileAds.initialize(context)
                        val adRequest = AdRequest.Builder().build()

                        InterstitialAd.load(context, "ca-app-pub-9646388292265496/3047776181", adRequest, object : InterstitialAdLoadCallback() {
                            override fun onAdFailedToLoad(adError: LoadAdError) {
                                Log.d("wami", adError.message)
                                mInterstitialAd = null
                            }

                            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                                Log.d("wami", "Ad was loaded.")
                                mInterstitialAd = interstitialAd
                            }
                        })

                        if (mInterstitialAd != null) {
                            mInterstitialAd?.show(context as Activity)
                        }

                        dialog.dismiss()
                    }

                }).show()

        if (alertDialog.getTitleIconView() != null) {

            Glide.with(context).load(R.drawable.dialog_icon).into(alertDialog.getTitleIconView()!!)
        }

        alertDialog.getContentTextView()!!.text = msg //Set content text
        alertDialog.getContentTextView()!!.setTextColor(getColor(context, R.color.black)) //Set content text color

        alertDialog.getPositiveButtonIconView()!!.setImageDrawable(getDrawable(context, R.drawable.check)) //Set positive button icon drawable
        alertDialog.getPositiveButtonIconView()!!.setColorFilter(getColor(context, R.color.black)) //Set positive button icon drawable color
        alertDialog.getPositiveButtonTextView()!!.text = "Watch Ad" //Set positive button text

        alertDialog.getGotItButtonIconView()!!.setImageDrawable(getDrawable(context, R.drawable.clear)) //Set got it button icon drawable
        alertDialog.getGotItButtonIconView()!!.setColorFilter(getColor(context, R.color.black)) //Set negative button icon drawable color
        alertDialog.getGotItButtonTextView()!!.text = "Cancel" //Set got it button text

    }
}

