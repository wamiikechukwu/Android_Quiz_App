package com.wamiikechukwukanu.quizapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wamiikechukwukanu.quizapp.databinding.ActivityOnboardingBinding
import com.wamiikechukwukanu.quizapp.onboarding.OnboardingDataItems
import com.wamiikechukwukanu.quizapp.onboarding.OnboardingPageAdapter

class OnboardingActivity : AppCompatActivity() {

    //    THE OBJECT I WILL USE FOR THE DATABINDING
    lateinit var binding: ActivityOnboardingBinding

    //    THE ADAPTER VARIABLE
    private lateinit var mPagerAdapter: OnboardingPageAdapter

    //    THE ARRAYLIST VARIABLE
    private lateinit var mModel: ArrayList<OnboardingDataItems>

    //    POSITION OF THE VIEWPAGER ADAPTER
    var viewPagerAdapterPosition = 0

    //    THE ANIMATION
    lateinit var mAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        GETTING THE ONBOARDING STATE
        if (restoredOnboardingState()) {
            startActivity(Intent(this@OnboardingActivity, MainActivity::class.java))
//            STOPS THE PREVIOUS ACTIVITY
            finish()
        }

//        HIDE THE ACTION BAR
        supportActionBar?.hide()

//        ASSOCIATING THE LAYOUT FILE WITH THE ACTIVITY
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)

//      THIS CONTAINS THE DATA MODEL (ARRAYLIST)
        settingUpTheDataModel()

        mPagerAdapter = OnboardingPageAdapter(this@OnboardingActivity, mModel)
        binding.viewPager.adapter = mPagerAdapter

//        SET THE TABLAYOUT WITH THE VIEWPAGER
        binding.onboardTabLayout.setupWithViewPager(binding.viewPager)

//        SETTING PADDING TO SHOW THE  NEXT CARD'S
        binding.viewPager.setPadding(40, 0, 40, 0)

//        ONCLICK OF THE BUTTON, MOVE TO THE NEXT VIEW PAGE
        binding.onboardNextButton.setOnClickListener {

//            THE INT POSITION THE VIEWPAGER IS IN, IS STORED HERE
            viewPagerAdapterPosition = binding.viewPager.currentItem

            //SETTING THE ANIMATION TO THE GET STARTED BUTTON
            mAnimation = AnimationUtils.loadAnimation(applicationContext, R.anim.botton_anim)

//            IF THE VIEW PAGER IS NOT AT THE END OF THE SCREEN, THEN CLICKING ON THE NEXT BUTTON
//            WILL MOVE THE VIEW PAGER
            if (viewPagerAdapterPosition < mModel.size) {
                viewPagerAdapterPosition++

                movingTheViewPager()
            }

//            WHEN THE CURRENT POSITION OF THE ONBOARDING SCREEN IS THAT LAST
//            AND WHEN THE NEXT BOTTON IS CLICKED AT THE LAST SCREEN
            if (viewPagerAdapterPosition == mModel.size) {

                settingTheViews()
            }
        }

        binding.getStarted.setOnClickListener {
            intent = Intent(this@OnboardingActivity, MainActivity::class.java)
            startActivity(intent)
            saveOnboardingState()
            finish()
        }


//        ONCLICK OF THE SKIP... SHOW THE NEXT ACTIVITY
        binding.onboardSkipText.setOnClickListener {
            startActivity(Intent(this@OnboardingActivity, MainActivity::class.java))
            saveOnboardingState()
            finish()
        }


    }

    //   SAVE THE STATE OF THE ONBOARDING PROCESS
    private fun saveOnboardingState() {
        //    SHARED PREFERENCES TO STORE THE STATE OF THE ONBOARDING
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("onboarding_state", MODE_PRIVATE)
//  STORING VALUES INTO THE SHARED PREFERENCE
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean("state", true)
        editor.apply()
        editor.commit()
    }

    private fun restoredOnboardingState(): Boolean {
        //    SHARED PREFERENCES TO STORE THE STATE OF THE ONBOARDING
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("onboarding_state", MODE_PRIVATE)
        val isOboardingOpenBefore: Boolean = sharedPreferences.getBoolean("state", false)
        return isOboardingOpenBefore
    }

    //    FOR THE DATAMODEL/ARRAYLIST
    private fun settingUpTheDataModel() {

//      SETUP THE DATAMODEL
        mModel = ArrayList()
        mModel.add(OnboardingDataItems(R.drawable.africa_map, "Welcome to Africa", "Our Home", R.color.first_color))
        mModel.add(OnboardingDataItems(R.drawable.pyramids, "Explore the Continent", "Find the paradise", R.color.second_color))
        mModel.add(OnboardingDataItems(R.drawable.south_africa_flag, "See the Countries", "Learn their culture", R.color.third_color))

    }

    //  MOVING THE VIEWPAGER
    private fun movingTheViewPager() {
        //                SET THE VIEW PAGER SCREEN TO THE NEXT, IF THE LAST SCREEN HAVENT BEEN REACHED
        binding.viewPager.currentItem = viewPagerAdapterPosition
    }

    //    MAKING VIEWS INVISIBLE OR VISIBLE
    private fun settingTheViews() {
        // THEN PERFORM THESE OPERATION
        binding.getStarted.visibility = View.VISIBLE
        binding.onboardTabLayout.visibility = View.INVISIBLE
        binding.onboardNextButton.visibility = View.INVISIBLE
        binding.onboardSkipText.visibility = View.INVISIBLE

        binding.getStarted.animation = mAnimation

    }

}

