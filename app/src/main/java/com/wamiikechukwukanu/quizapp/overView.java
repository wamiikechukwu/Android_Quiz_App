package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class overView extends AppCompatActivity {

    //variable to store the referenced ID of the adView
    public AdView overviewAd1;
    public AdView overViewAd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_view);

        //Referencing the aadId from admob and initialing it
        MobileAds.initialize(this, "ca-app-pub-9646388292265496~7436300103");

        overviewAd1 = findViewById(R.id.overviewAd1);
        overViewAd2 = findViewById(R.id.overviewAd2);

        AdRequest adRequest = new AdRequest.Builder().build();
        overviewAd1.loadAd(adRequest);
        overViewAd2.loadAd(adRequest);

        getWindow().setBackgroundDrawable(null);
    }

    //adding the menu to this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu1:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;

            case R.id.menu2:
                Toast.makeText(this, "Contact us clicked", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
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
