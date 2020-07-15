package com.wamiikechukwukanu.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.wamiikechukwukanu.quizapp.onboarding.OnboardingDataItems
import com.wamiikechukwukanu.quizapp.onboarding.OnboardingPageAdapter

class ViewPager2Activity : AppCompatActivity() {

    lateinit var mPagerAdapter: OnboardingPageAdapter
    lateinit var mModel: ArrayList<OnboardingDataItems>
    lateinit var mViewPager2: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2_activity)

        mViewPager2 = findViewById(R.id.viewpager2)

        mModel = ArrayList()
        mModel.add(OnboardingDataItems(R.drawable.didyouknow0, "Welcome to Africa", "Our Home", R.color.first_color))
        mModel.add(OnboardingDataItems(R.drawable.didyouknow0, "Explore the Contitent", "Find the paradise", R.color.second_color))
        mModel.add(OnboardingDataItems(R.drawable.didyouknow0, "See the Countries", "Play Games", R.color.third_color))

        mPagerAdapter = OnboardingPageAdapter(this@ViewPager2Activity, mModel)
        mViewPager2.adapter = mPagerAdapter

        mViewPager2.setPadding(40, 0, 40, 0)


    }
}