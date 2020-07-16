package com.wamiikechukwukanu.quizapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.wamiikechukwukanu.quizapp.onboarding.OnboardingDataItems
import com.wamiikechukwukanu.quizapp.onboarding.OnboardingPageAdapter

class ViewPager2Activity : AppCompatActivity() {

    //    THE ADAPTER VARIABLE
    lateinit var mPagerAdapter: OnboardingPageAdapter

    //    THE ARRAYLIST VARIABLE
    lateinit var mModel: ArrayList<OnboardingDataItems>

    //    VIEWPAGER
    lateinit var mViewPager2: ViewPager

    //    TAB INDICATOR
    lateinit var tabLayout: TabLayout

    //    POSITION OF THE VIEWPAGER ADAPTER
    var viewPagerAdapterPosition = 0

    //    ONBOARDING BOTTON
    lateinit var onboardNextButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        HIDE THE ACTION BAR
        supportActionBar?.hide()

        setContentView(R.layout.activity_view_pager2_activity)

        mViewPager2 = findViewById(R.id.viewpager2)

//        TAB LAYOUT
        tabLayout = findViewById(R.id.onboard_tab_layout)

//        ONBOARDING BUTTON
        onboardNextButton = findViewById(R.id.onboard_next_button)


//        SETUP THE DATAMODEL
        mModel = ArrayList()
        mModel.add(OnboardingDataItems(R.drawable.didyouknow0, "Welcome to Africa", "Our Home", R.color.first_color))
        mModel.add(OnboardingDataItems(R.drawable.didyouknow0, "Explore the Contitent", "Find the paradise", R.color.second_color))
        mModel.add(OnboardingDataItems(R.drawable.didyouknow0, "See the Countries", "Play Games", R.color.third_color))

        mPagerAdapter = OnboardingPageAdapter(this@ViewPager2Activity, mModel)
        mViewPager2.adapter = mPagerAdapter

//        SET THE TABLAYOUT WITH THE VIEWPAGER
        tabLayout.setupWithViewPager(mViewPager2)

//        SETTING PADDING TO SHOW THE  NEXT CARD'S
        mViewPager2.setPadding(40, 0, 40, 0)

//        ONCLICK OF THE BUTTON, MOVE TO THE NEXT VIEWP PAGE
        onboardNextButton.setOnClickListener {

//            THE INT POSITION THE VIEWPAGER IS IN, IS STORED HERE
            viewPagerAdapterPosition = mViewPager2.currentItem

            if (viewPagerAdapterPosition < mModel.size) {
                viewPagerAdapterPosition++
                mViewPager2.currentItem = viewPagerAdapterPosition
            }
        }


    }
}