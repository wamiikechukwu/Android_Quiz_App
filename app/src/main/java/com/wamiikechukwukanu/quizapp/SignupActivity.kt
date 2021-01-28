package com.wamiikechukwukanu.quizapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        auth = Firebase.auth
    }

    fun signUpButton(view: View) {
        validation()
    }

    fun validation() {
        val userDisplayName = username_edit_text.text.toString()
        val userEmail = signup_email_edit_text.text.toString()
        val userPassword = signup_password_edit_text.text.toString()
        val confirmPassword = confirm_password_edit_text.text.toString()

//        USER NAME IS NOT EMPTY
        if ((userDisplayName.isEmpty())) {
            username_edit_text.error = "User Name Required"
            username_edit_text.requestFocus()
        } else if ((userEmail.isEmpty())) {
            signup_email_edit_text.error = "Email Required"
            signup_email_edit_text.requestFocus()
        } else if ((userPassword.isEmpty())) {
            signup_password_edit_text.error = "Password Required"
            signup_password_edit_text.requestFocus()
// CHECKING IF USER USES SPECIAL CHARACTER
        } else if (!userDisplayName.matches(Regex("[A-Za-z0-9]+"))) {
            username_edit_text.error = "No Special Character Allowed"
            username_edit_text.requestFocus()
//        CHECK IF USER DISPLAY NAME IS LESS THAN TWO CHARACTERS
        } else if (userDisplayName.length <= 3) {
            username_edit_text.error = "Display Name too Short"
            username_edit_text.requestFocus()

//           CHECK THAT EMAIL IS CORRECT AND CONTAIN @ AND .
        } else if (!(userEmail.contains("@", true)) || !(userEmail.contains(".", true))) {
            signup_email_edit_text.error = "Email not Complete"
            signup_email_edit_text.requestFocus()
        } else if (userPassword.length < 6) {
            signup_password_edit_text.error = "Password too short"
            signup_password_edit_text.requestFocus()
        } else if (confirmPassword.isEmpty()) {
            confirm_password_edit_text.error = "Password Required"
            confirm_password_edit_text.requestFocus()
        } else if (confirmPassword != userPassword) {
            confirm_password_edit_text.error = "Does not Match"
            confirm_password_edit_text.requestFocus()
        } else {
            progress_bar.visibility = View.VISIBLE
            auth.createUserWithEmailAndPassword(userEmail, confirmPassword)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            progress_bar.visibility = View.INVISIBLE
                            Toast.makeText(this, "Sign Up Success", Toast.LENGTH_LONG).show()
                            val user = auth.currentUser
                        } else {
                            progress_bar.visibility = View.INVISIBLE
                            // If sign in fails, display a message to the user.
                            Toast.makeText(baseContext, "Sign Up",
                                    Toast.LENGTH_SHORT).show()
                        }

                        // ...
                    }
        }
    }
}
