package com.wamiikechukwukanu.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SigninActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        supportActionBar?.title = ""
    }
}


