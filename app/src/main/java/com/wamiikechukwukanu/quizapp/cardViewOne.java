package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class cardViewOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_one);

        //Referencing the aadId from admob and initialing it
        MobileAds.initialize(this, "ca-app-pub-9646388292265496/4392647445");

        ImageView imageView = findViewById(R.id.didyouknow1);
        Glide.with(this).load(R.drawable.didyouknow1).into(imageView);

        AdView adView0 = findViewById(R.id.overviewAd0);
        AdView adView1 = findViewById(R.id.overviewAd1);

        AdRequest adRequest = new AdRequest.Builder().build();

        adView0.loadAd(adRequest);
        adView1.loadAd(adRequest);

    }

    //This @Override method here inflate/add the menu to the activity
    //and this must be added unto every activity you want the menu to appear on
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    //This @Override method tells the menu what to do  or displays when a user clicks on it
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu1:
                Intent intent = new Intent(this, contactUs.class);
                startActivity(intent);
                return true;

            case R.id.menu2:
                String address = "wami7470@gmail.com";
                String subject = "Africa Quiz App";
                String text = "I wish to contact the developer of Africa Quiz App";
                Intent sendMessage = new Intent(Intent.ACTION_SEND);
                sendMessage.setType("*/*");
                sendMessage.putExtra(Intent.EXTRA_EMAIL, address);
                sendMessage.putExtra(Intent.EXTRA_SUBJECT, subject);
                sendMessage.putExtra(Intent.EXTRA_TEXT, text);
                if (sendMessage.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendMessage);
                }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, didYouKnow.class);
        startActivity(intent);
    }
}
