package com.wamiikechukwukanu.quizapp.ui

import android.content.Context
import android.content.DialogInterface
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.gurutouchlabs.kenneth.elegantdialog.ElegantActionListeners
import com.gurutouchlabs.kenneth.elegantdialog.ElegantDialog
import com.wamiikechukwukanu.quizapp.R
import com.wamiikechukwukanu.quizapp.db.Database
import com.wamiikechukwukanu.quizapp.quizlogic.QuizLogic
import kotlinx.android.synthetic.main.activity_map_quiz.*
import kotlin.properties.Delegates

class FlagQuizActivity : AppCompatActivity() {
    //    HELPER CLASS
    lateinit var quizLogic: QuizLogic
    lateinit var database: Database
    lateinit var cursor: Cursor
    lateinit var firstBtn: Button
    lateinit var secondBtn: Button
    lateinit var thirdBtn: Button
    lateinit var fourthBtn: Button
    lateinit var fifthBtn: Button
    lateinit var sixthBtn: Button
    lateinit var seventhBtn: Button
    lateinit var eighthBtn: Button
    lateinit var ninthBtn: Button
    lateinit var tenthBtn: Button
    lateinit var eleventhBtn: Button
    lateinit var twelveBtn: Button

    //    GLOBAL VARIABLE FOR THE CURRENT FLAG POSITION
    var currentMapPosition by Delegates.notNull<Int>()
    private var userCurrentPoint by Delegates.notNull<Int>()
    private var setUserPoint by Delegates.notNull<Int>()

    //    ADs
    private var mInterstitialAd: InterstitialAd? = null
    private var mRewardedAd: RewardedAd? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        setContentView(R.layout.activity_map_quiz)

        quizLogic = QuizLogic(this)
        database = Database(applicationContext)

//        AD LOADER FOR ALL TYPES OF ADs
        MobileAds.initialize(this)
        val adRequest = AdRequest.Builder().build()
        banner_adView.loadAd(adRequest)

        findViews()

        currentMapPosition = quizLogic.getCurrentSharedPreference()

        quizLogic.setButtons(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)

//        SET THE LETTERS TO THE LOWER BUTTONS
        getCurrentRowFromDatabase(currentMapPosition, bottom_first_btn, bottom_second_btn, bottom_third_btn, bottom_fourth_btn, bottom_fifth_btn, bottom_sixth_btn, bottom_seventh_btn, bottom_eight_btn, bottom_ninth_btn, bottom_tenth_btn, bottom_eleventh_btn, bottom_twelve_btn)
        getCurrentMapState(currentMapPosition)

//        CHECK IF THE MAP NAME HAS BEEN ADDED TO THE DATA BASE BEFORE NOW
        if (quizLogic.checkIfSavedToDataBase()) {
            insertIntoRoomDataBase()
//            SET SHARED PREF TO TRUE, BECAUSE DATABASE
            quizLogic.saveIntoDataBaseOnce(false)
        }

//        ADs
        InterstitialAd.load(this, "ca-app-pub-9646388292265496/3047776181", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d("quiz", adError.message)
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d("quiz", "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })

//        TODO CHANGE THE AD ID
        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917", adRequest, object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d("REWARD AD ", adError.message)
                mRewardedAd = null
            }

            override fun onAdLoaded(rewardedAd: RewardedAd) {
                Log.d("REWARD AD ", "Ad was loaded.")
                mRewardedAd = rewardedAd
            }
        })
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

    private fun findViews() {
        firstBtn = findViewById(R.id.first_btn)
        secondBtn = findViewById(R.id.second_btn)
        thirdBtn = findViewById(R.id.third_btn)
        fourthBtn = findViewById(R.id.fourth_btn)
        fifthBtn = findViewById(R.id.fifth_btn)
        sixthBtn = findViewById(R.id.sixth_btn)
        seventhBtn = findViewById(R.id.seventh_btn)
        eighthBtn = findViewById(R.id.eight_btn)
        ninthBtn = findViewById(R.id.ninth_btn)
        tenthBtn = findViewById(R.id.tenth_btn)
        eleventhBtn = findViewById(R.id.eleventh_btn)
        twelveBtn = findViewById(R.id.twelve_btn)
    }

    private fun getCurrentRowFromDatabase(position: Int, firstBtn: Button, secondBtn: Button, thirdBtn: Button, fourthBtn: Button, fifthBtn: Button, sixthBtn: Button,
                                          seventhBtn: Button, eighthBtn: Button, ninthBtn: Button, tenthBtn: Button, eleventhBtn: Button, twelfthBbn: Button) {
        cursor = database.getFlagNameByIndex((position + 1))
        while (cursor.moveToNext()) {
            //   THE POSITION FOR THE FLAG IMAGE IS 0 INDEX  BUT
            //   INSERTION IN THE DATABASE IS STARTING FROM 1

            firstBtn.text = cursor.getString(1).toString()
            secondBtn.text = cursor.getString(2).toString()
            thirdBtn.text = cursor.getString(3).toString()
            fourthBtn.text = cursor.getString(4).toString()
            fifthBtn.text = cursor.getString(5).toString()
            sixthBtn.text = cursor.getString(6).toString()
            seventhBtn.text = cursor.getString(7).toString()
            eighthBtn.text = cursor.getString(8).toString()
            ninthBtn.text = cursor.getString(9).toString()
            tenthBtn.text = cursor.getString(10).toString()
            eleventhBtn.text = cursor.getString(11).toString()
            twelfthBbn.text = cursor.getString(12).toString()

        }
    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.bottom_first_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            R.id.bottom_second_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            R.id.bottom_third_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            R.id.bottom_fourth_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            R.id.bottom_fifth_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            R.id.bottom_sixth_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            R.id.bottom_seventh_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            R.id.bottom_eight_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            R.id.bottom_ninth_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            R.id.bottom_tenth_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            R.id.bottom_eleventh_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            R.id.bottom_twelve_btn -> {
                quizLogic.setTextFromButtonPressed(quizLogic.getTextFromButtonPressed(view as Button), firstBtn, secondBtn, thirdBtn, fourthBtn, fifthBtn, sixthBtn, seventhBtn, eighthBtn, ninthBtn, tenthBtn, eleventhBtn, twelveBtn)
                quizLogic.checkCorrectFlagName(currentMapPosition, first_btn, second_btn, third_btn, fourth_btn, fifth_btn, sixth_btn, seventh_btn, eight_btn, ninth_btn, tenth_btn, eleventh_btn, twelve_btn)
            }
            else -> {
            }
        }
    }

    fun topBtnClick(view: View) {
        userCurrentPoint = quizLogic.getUserPoint()
        when (view.id) {
            R.id.first_btn -> {
                if (firstBtn.text.isNotBlank() && userCurrentPoint >= 0) {
                    firstBtn.text = ""
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                    quizLogic.userPoint((userCurrentPoint - 2))
                    Toast.makeText(this,"" +userCurrentPoint,Toast.LENGTH_SHORT).show()
                }
            }
            R.id.second_btn -> {
                if (secondBtn.text.isNotBlank()) {
                    secondBtn.text = " "
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                }
            }
            R.id.third_btn -> {
                if (thirdBtn.text.isNotBlank()) {
                    thirdBtn.text = ""
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                }
            }
            R.id.fourth_btn -> {
                if (fourthBtn.text.isNotBlank()) {
                    fourthBtn.text = ""
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                }
            }
            R.id.fifth_btn -> {
                if (fifthBtn.text.isNotBlank()) {
                    fifthBtn.text = ""
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                }
            }
            R.id.sixth_btn -> {
                if (sixthBtn.text.isNotBlank()) {
                    sixthBtn.text = ""
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                }
            }
            R.id.seventh_btn -> {
                if (seventhBtn.text.isNotBlank()) {
                    seventhBtn.text = ""
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                }
            }
            R.id.eight_btn -> {
                if (eighthBtn.text.isNotBlank()) {
                    eighthBtn.text = ""
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                }
            }
            R.id.ninth_btn -> {
                if (ninthBtn.text.isNotBlank()) {
                    ninthBtn.text = ""
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                }
            }
            R.id.tenth_btn -> {
                if (tenthBtn.text.isNotBlank()) {
                    tenthBtn.text = ""
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                }
            }
            R.id.eleventh_btn -> {
                if (eleventhBtn.text.isNotBlank()) {
                    eleventhBtn.text = ""
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                }
            }
            R.id.twelve_btn -> {
                if (eleventhBtn.text.isNotBlank()) {
                    eleventhBtn.text = ""
                    if (mInterstitialAd != null) {
                        mInterstitialAd?.show(this)
                    }
                }
            }
        }
    }

    fun hintButton(view: View) {
//        GET THE POINT STORED IN THE SHARED PREF.
        userCurrentPoint = quizLogic.getUserPoint()
        showAlertDialog(this, "Watch an ad to get hint points \n\n Hint points are used to erase mistaken letters")

    }

    fun showAlertDialog(context: Context, msg: String) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(msg)
        builder.setPositiveButton("Watch Ad"){
            dialog, which ->
            if (mRewardedAd != null) {
                mRewardedAd?.show(this) {
                    Toast.makeText(this, " 2 POINT AWARDED", Toast.LENGTH_SHORT).show()
//                 THEN ADD +2 TO THE ALREADY SAVED POINT
                    quizLogic.userPoint((userCurrentPoint + 2))
                }
            } else {
                Toast.makeText(this, "Reward not available, try again after 5 sec", Toast.LENGTH_SHORT).show()
            }
        }
        builder.setNegativeButton("Cancel"){
            dialog, which -> Toast.makeText(context,"You have lost your reward",Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }
}
