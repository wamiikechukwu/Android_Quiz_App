package com.wamiikechukwukanu.quizapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
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
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity() {

    //    STRINGS FOR THE SIGN UP
    lateinit var signUpUserDisplayName: String
    lateinit var signUpUserEmail: String
    lateinit var signUpUserPassword: String

    lateinit var GoogleSignInClient: GoogleSignInClient

    private lateinit var auth: FirebaseAuth

    val RC_SIGN_IN = 1

    //    SHARED PREFERENCE
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        supportActionBar?.hide()

        sharedPreferences = this.getSharedPreferences("Google_Auth", Context.MODE_PRIVATE)

        createRequest()

        // Initialize Firebase Auth
        auth = Firebase.auth

        sign_in_button.setOnClickListener {
            signIn()
        }
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        //                            SHARED PREFERENCES
//        val editor: SharedPreferences.Editor = sharedPreferences.edit()
//        editor.putString("user_id", currentUser?.uid);
//        editor.putString("user_display_name", currentUser?.displayName);
//        editor.putString("user_email", currentUser?.email);
////                            editor.putString("user_isEmailVerified", );
//        editor.putString("user_photo_url", currentUser?.photoUrl.toString());
//        editor.putBoolean("user_inserted", true)
//        editor.apply()
//        editor.commit()
//        TODO
        //  updateUI(currentUser)

        if (currentUser != null) {
//            START INTENT
//            TODO
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d("FIREBASE", "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("FIREBASE", "Google sign in failed", e)
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
                // ...
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        fun firebaseAuthWithGoogle(idToken: String) {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            auth.signInWithCredential(credential)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("FIREBASE", "signInWithCredential:success")
                            val user = auth.currentUser

//                            user.isEmailVerified

//                            SHARED PREFERENCES
                            val editor: SharedPreferences.Editor = sharedPreferences.edit()
                            editor.putString("user_id", user?.uid)
                            editor.putString("user_display_name", user?.displayName)
                            editor.putString("user_email", user?.email)
//                            editor.putString("user_isEmailVerified", );
                            editor.putString("user_photo_url", user?.photoUrl.toString())
                            editor.apply()
                            editor.commit()

//                            TODO
                            //updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("FIREBASE", "signInWithCredential:failure", task.exception)
                            // ...
                            Snackbar.make(findViewById(R.id.signin), "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
//                            TODO
                            // updateUI(null)
                        }

                        // ...
                    }
        }

    }

    fun emailpassLogin(view: View) {}

    fun emailpassSignUp(view: View) {
        signUpUserDisplayName = username_edit_text.text.toString()
        signUpUserEmail = signup_email_edit_text.text.toString()
        signUpUserPassword = signup_password_edit_text.text.toString()

//        VALID THE USER INPUT
        signUpValidation()
    }

    //    FUNCTIONS DECLARATION
    private fun signUpValidation() {
        //        MAKE SURE THAT THE EDIT TEXT IS NOT EMPTY
        if ((signUpUserDisplayName.isEmpty())) {
            username_edit_text.error = "User Name Required"
            username_edit_text.requestFocus()
        } else if ((signUpUserEmail.isEmpty())) {
            signup_email_edit_text.error = "Email Required"
            signup_email_edit_text.requestFocus()
        } else if ((signUpUserPassword.isEmpty())) {
            signup_password_edit_text.error = "Password Required"
            signup_password_edit_text.requestFocus()
// CHECKING IF USER USES SPECIAL CHARACTER
        } else if (!signUpUserDisplayName.matches(Regex("[A-Za-z0-9]+"))) {
            username_edit_text.error = "No Special Character Allowed"
            username_edit_text.requestFocus()

//        CHECK IF USER DISPLAY NAME IS LESS THAN TWO CHARACTERS
        } else if (signUpUserDisplayName.length <= 3) {
            username_edit_text.error = "Display Name too Short"
            username_edit_text.requestFocus()

//           CHECK THAT EMAIL IS CORRECT AND CONTAIN @ AND .
        } else if (!(signUpUserEmail.contains("@", true)) || !(signUpUserEmail.contains(".", true))) {
            signup_email_edit_text.error = "Email not Complete"
            signup_email_edit_text.requestFocus()
        } else if (signUpUserPassword.length < 6) {
            signup_password_edit_text.error = "Password too short"
            signup_password_edit_text.requestFocus()
        } else {
            Toast.makeText(this, "RUN", Toast.LENGTH_SHORT).show()
        }
    }
}


