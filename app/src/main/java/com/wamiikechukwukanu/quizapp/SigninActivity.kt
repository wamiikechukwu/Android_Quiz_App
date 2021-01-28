package com.wamiikechukwukanu.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        supportActionBar?.title = ""

        auth = Firebase.auth
    }


    fun validation() {
//         GET THE CURRENT USER INPUTS
        val userLoginEmail = email_edit_text.text.toString()
        val userLoginPassword = password_edit_text.text.toString()

//        VALIDATE THE SIGN IN PARAMETERS
        if (userLoginEmail.isEmpty()) {
            email_edit_text.error = "Email Required"
            email_edit_text.requestFocus()
        } else if (userLoginPassword.isEmpty()) {
            password_edit_text.error = "Password Required"
            password_edit_text.requestFocus()
        } else if (!(userLoginEmail.contains("@", true)) || !(userLoginEmail.contains(".", true))) {
            email_edit_text.error = "Email not Correct"
            email_edit_text.requestFocus()
        } else if (userLoginPassword.length < 6) {
            password_edit_text.error = "Password too short"
            password_edit_text.requestFocus()
        } else {
            progress_bar.visibility = View.VISIBLE
            auth.signInWithEmailAndPassword(userLoginEmail, userLoginPassword)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            progress_bar.visibility = View.INVISIBLE
                            // Sign in success, update UI with the signed-in user's information
                            val user = auth.currentUser
                            Toast.makeText(baseContext, "Sign In Success",
                                    Toast.LENGTH_LONG).show()

                        } else {
                            progress_bar.visibility = View.VISIBLE
                            // If sign in fails, display a message to the user.
                            Toast.makeText(baseContext, "Sign In Failed",
                                    Toast.LENGTH_LONG).show()
                            // ...
                        }

                        // ...
                    }
        }
    }

    fun EmailLoginInButton(view: View) {
        validation()
    }

    fun createAccountButton(view: View) {
//        TODO
//        ADD INTENT FLAG
        intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }


}


