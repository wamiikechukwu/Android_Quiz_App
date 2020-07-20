package com.wamiikechukwukanu.quizapp.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.getColor
import androidx.viewpager.widget.PagerAdapter
import com.wamiikechukwukanu.quizapp.R

class OnboardingPageAdapter(val mContext: Context, var mArrayList: ArrayList<OnboardingDataItems>) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return mArrayList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val mView = LayoutInflater.from(mContext).inflate(R.layout.onboarding_screen, container, false)
        val mTitle: TextView
        val mImage: ImageView
        val mSubTitle: TextView

//        FOR THE CARDVIEW
        val mCardView: CardView

        mTitle = mView.findViewById(R.id.onboard_title)
        mImage = mView.findViewById(R.id.onboard_image)
        mSubTitle = mView.findViewById(R.id.onboard_subtitle)

        mCardView = mView.findViewById(R.id.onboard_cardview)

        mTitle.text = mArrayList[position].onboardingTitle
        mImage.setImageResource(mArrayList[position].onboardingImage)

        mSubTitle.text = mArrayList[position].onboardingSubTitle
        mCardView.setCardBackgroundColor(getColor(mContext, mArrayList[position].onboardingCardColor))

        container.addView(mView, 0)

        return mView
    }
}