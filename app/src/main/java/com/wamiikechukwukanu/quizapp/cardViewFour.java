package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class cardViewFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_four);

        ImageView imageView = findViewById(R.id.didyouknow4);
        Glide.with(this).load(R.drawable.didyouknow4).into(imageView);

        //Referencing the aadId from admob and initialing it
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");

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

    public void goBack(View view) {
        Intent intent = new Intent(this, didYouKnow.class);
        startActivity(intent);
    }
}
