package com.wamiikechukwukanu.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        HIDE THE SUPPORT ACTION BAR IN THIS ACTIVITY
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

    }

    fun signin(view: View) {
        intent = Intent(this, SigninActivity::class.java)
        startActivity(intent)
    }

    fun setProfilePicture() {
//        if ()
//        TODO
    }
}
