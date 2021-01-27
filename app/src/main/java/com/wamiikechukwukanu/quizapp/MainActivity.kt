package com.wamiikechukwukanu.quizapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //    SHARED PREFERENCES
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        HIDE THE SUPPORT ACTION BAR IN THIS ACTIVITY
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("Google_Auth", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean("user_inserted", false)
        editor.apply()
        editor.commit()

//        METHODS
        setProfilePicture()
    }

    fun signin(view: View) {
        intent = Intent(this, SigninActivity::class.java)
        startActivity(intent)
    }

    fun setProfilePicture() {
//        CHECK IF THE USER HAS LOG IN BEFORE
//        USE THE SHARED PREFERENCES TO STORE USERS STATE
        if (!(sharedPreferences.getBoolean("user_inserted", true)) || sharedPreferences.getString("user_photo_url", "null") == "null") {
//            IF THE SHARED PREFERENCES KEY IS IT TOO FALSE THE USE THE LOCAL PICTURE
            Glide.with(this).load(R.drawable.avatar).into(box_profile_picture)
        } else {
            Glide.with(this).load(sharedPreferences.getString("user_photo_url", "null")).into(box_profile_picture)
        }
    }
}
