package com.wamiikechukwukanu.quizapp.Intro_Screen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.wamiikechukwukanu.quizapp.R;

import java.util.ArrayList;
import java.util.List;

import pageViewAdapter.IntroScreenPageViewAdapter;


public class IntroActivity extends AppCompatActivity {

    IntroScreenPageViewAdapter introScreenPageViewAdapter;
    private ViewPager screenPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //PUTTING VALUE INTO THE LIST
        List<introScreenDataModel> modelList = new ArrayList<>();
        modelList.add(new introScreenDataModel("Hello Africa", "This is Africa", R.drawable.didyouknow0));
        modelList.add(new introScreenDataModel("Hello Nigeria", "This is Nigeria", R.drawable.didyouknow1));
        modelList.add(new introScreenDataModel("Hello Rivers State", "This is Rivers State", R.drawable.didyouknow3));

        //SETTING UP THE VIEW PAGER
        screenPager = findViewById(R.id.introPageView);
        introScreenPageViewAdapter = new IntroScreenPageViewAdapter(this, modelList);
        screenPager.setAdapter(introScreenPageViewAdapter);

        //
    }
}
