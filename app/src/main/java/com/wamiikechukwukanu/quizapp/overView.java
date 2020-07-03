package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class overView extends AppCompatActivity {

    //variable to store the referenced ID of the adView
    public AdView overviewAd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide the action bar on this activity
        getSupportActionBar().hide();

        //after hiding the action bar, display the activity layout file
        setContentView(R.layout.activity_over_view);

        //Referencing the ad Id from admob and initialing it
        MobileAds.initialize(this, "ca-app-pub-9646388292265496/4392647445");

        overviewAd1 = findViewById(R.id.overviewAd1);

        AdRequest adRequest = new AdRequest.Builder().build();
        overviewAd1.loadAd(adRequest);
    }

    public void questionInto(View view) {
        Intent intent = new Intent(this, introStartQuiz.class);
        startActivity(intent);
    }

    public void didYouKnow(View view) {
        Intent intent = new Intent(this, didYouKnow.class);
        startActivity(intent);
    }

    public void africaNews(View view) {
        Intent intent = new Intent(this, africaNews.class);
        startActivity(intent);
    }

    public void misconAfrica(View view) {
        Intent intent = new Intent(this, misconAfrica.class);
        startActivity(intent);
    }

}

