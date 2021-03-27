 package com.wamiikechukwukanu.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var GoogleSignInClient: GoogleSignInClient

    val RC_SIGN_IN = 123

    // Access a Cloud Firestore instance from your Activity
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        supportActionBar?.title = ""

        auth = Firebase.auth

        sign_in_button.setOnClickListener(View.OnClickListener {
            createRequest()
            signIn()
        })
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
                            Toast.makeText(baseContext, "Sign In Successfully",
                                    Toast.LENGTH_LONG).show()

                            //                            MOVE TO MAIN ACTIVITY
                            intent = Intent(this, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)

                        } else {
                            progress_bar.visibility = View.INVISIBLE
                            // If sign in fails, display a message to the user.
                            Toast.makeText(baseContext, "Create an Account or Use Google Sign in",
                                    Toast.LENGTH_LONG).show()
                            // ...
                        }

                        // ...
                    }
        }
    }

    fun createRequest() {
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        // Build a GoogleSignInClient with the options specified by gso.
        GoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }


    private fun signIn() {
        val signInIntent = GoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }


    fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = Firebase.auth.currentUser

                        user?.let {

                            // Add a new document with a generated ID
                            val newUser = userRegistrationDetails(user.displayName.toString(), user.email.toString(), user.photoUrl.toString())

                            db.collection("AfricanQuizAppUsers").document(user.email.toString())
                                    .set(newUser)
                                    .addOnSuccessListener {
                                    }
                                    .addOnFailureListener { e ->
                                        Toast.makeText(this, "Google Details not Saved", Toast.LENGTH_LONG).show()
                                    }

                            // MOVE TO MAIN ACTIVITY
                            Toast.makeText(this, "LOGIN", Toast.LENGTH_LONG).show()
                            intent = Intent(this, MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)

//                            TODO
                            //updateUI(user)
                        }
                    } else {
                        // If sign in fails, display a message to the user.
                        Snackbar.make(findViewById(R.id.signin), "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
//                            TODO
                        // updateUI(null)
                    }

                    // ...
                }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
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





