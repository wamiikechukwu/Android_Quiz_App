package com.wamiikechukwukanu.quizapp.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class OnboardingPageAdapter(val mContext: Context) : PagerAdapter() {

    var arrayList: ArrayList<OnboardingDataItems> = ArrayList()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as View

    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(View(`object` as Context?))
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val mView = LayoutInflater.from(mContext).inflate()
    }


}