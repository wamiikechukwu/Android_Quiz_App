package com.wamiikechukwukanu.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        HIDE THE SUPPORT ACTION BAR IN THIS ACTIVITY
        supportActionBar?.title = ""

        setContentView(R.layout.activity_main)
    }
}