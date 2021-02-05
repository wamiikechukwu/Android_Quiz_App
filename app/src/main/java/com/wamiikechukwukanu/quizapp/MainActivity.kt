package com.wamiikechukwukanu.quizapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    //    FOR THE IMAGES
    val PICK_IMAGE_REQUEST = 123

    lateinit var filePath: Uri

    // Access a Cloud Firestore instance from your Activity
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        HIDE THE SUPPORT ACTION BAR IN THIS ACTIVITY
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        auth = Firebase.auth



        setUserName()

    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        setUserName()

        if (currentUser != null) {
            //user is signin so displays SIGN OUT
            sigin.text = "SIGN OUT"

        } else {
            //no user signed in so displays SIGN IN
            sigin.text = "SIGN IN"
        }

        if (sigin.text.toString() == "SIGN IN") {
            sigin.setOnClickListener(View.OnClickListener { signin() })
        } else if (sigin.text.toString() == "SIGN OUT") {
            sigin.setOnClickListener(View.OnClickListener { signout() })
        }
    }

    fun signin() {
        intent = Intent(this, SigninActivity::class.java)
        startActivity(intent)
    }

    fun signout() {
        Toast.makeText(this, "Successfully Sign Out", Toast.LENGTH_SHORT).show()
        Firebase.auth.signOut()
        onStart()
    }


    fun getProfilePicture() {

        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Your Display Picture"), PICK_IMAGE_REQUEST)

//        startActivityForResult(Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI), PICK_IMAGE_REQUEST)


////        CHECK IF THE USER HAS LOG IN BEFORE
////        USE THE SHARED PREFERENCES TO STORE USERS STATE
//        if (!(sharedPreferences.getBoolean("user_inserted", true)) || sharedPreferences.getString("user_photo_url", "null") == "null") {
////            IF THE SHARED PREFERENCES KEY IS IT TOO FALSE THE USE THE LOCAL PICTURE
//            Glide.with(this).load(R.drawable.avatar).into(box_profile_picture)
//        } else {
//            Glide.with(this).load(sharedPreferences.getString("user_photo_url", "null")).into(box_profile_picture)
        //}
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            filePath = data?.data!!
            var currentUser = auth.currentUser
            try {
                currentUser?.let {
                    val profilePictureRef = FirebaseStorage.getInstance().reference.child(currentUser.email.toString())
                    val uploadTask = profilePictureRef.putFile(filePath)

                    val urlTask = uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task ->
                        if (!task.isSuccessful) {
                            task.exception?.let {
                                throw it
                            }
                        }
                        return@Continuation profilePictureRef.downloadUrl
                    }).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val downloadUri = task.result
                            addUploadRecordToDb(downloadUri.toString())
                        } else {
                            // Handle failures
                        }
                    }.addOnFailureListener {

                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun addUploadRecordToDb(uri: String) {
        val db = FirebaseFirestore.getInstance()
        var currentUser = auth.currentUser

//        val data = HashMap<String, Any>()
//        data["imageUrl"] = uri

        val userProfileImage = db.collection("AfricanQuizAppUsers")
                .document(currentUser?.email.toString())
        userProfileImage.update("userProfilePicture", uri)
                .addOnSuccessListener {
                    Glide.with(this).load(uri).into(box_profile_picture)
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Error ${it.message}", Toast.LENGTH_SHORT).show()
                }


    }

    fun setUserName() {
        val user = Firebase.auth.currentUser
        user?.let {
            val userNameReference = db.collection("AfricanQuizAppUsers").document(user.email.toString()).get()
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            val name = it.result.get("displayName") as String? ?: "John Doe"
                            box_profile_name_placeholder.text = name
                        }
                    }
                    .addOnFailureListener { exception ->
                        box_profile_name_placeholder.text = "John Doe"

                    }
        }
    }

    //    TODO
//    ADD PROFILE PICTURE
    fun imageToFireStore(view: View) {
        getProfilePicture()
    }

    fun dailyQuiz(view: View) {
        intent = Intent(this, DailyActivity::class.java)
        startActivity(intent)
    }
}
