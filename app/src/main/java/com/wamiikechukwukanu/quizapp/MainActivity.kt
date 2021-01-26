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

        setProfilePicture()
    }

    fun signin(view: View) {
        intent = Intent(this, SigninActivity::class.java)
        startActivity(intent)
    }

    fun setProfilePicture() {

        if (!(sharedPreferences.getBoolean("user_inserted", true))) {
            Glide.with(this).load(R.drawable.avatar).into(box_profile_picture)
        }
    }
}
