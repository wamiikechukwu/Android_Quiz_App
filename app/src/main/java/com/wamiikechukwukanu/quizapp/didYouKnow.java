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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class didYouKnow extends AppCompatActivity {

    public InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_did_you_know);

        //Referencing the aadId from admob and initialing it
        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        ImageView zero_pic = findViewById(R.id.zero_pic);
        Glide.with(this).load(R.drawable.didyouknow0).into(zero_pic);

        ImageView one_pic = findViewById(R.id.one_pic);
        Glide.with(this).load(R.drawable.didyouknow1).into(one_pic);

        ImageView two_pic = findViewById(R.id.two_pic);
        Glide.with(this).load(R.drawable.didyouknow2).into(two_pic);

        ImageView three_pic = findViewById(R.id.three_pic);
        Glide.with(this).load(R.drawable.didyouknow3).into(three_pic);

        ImageView four_pic = findViewById(R.id.four_pic);
        Glide.with(this).load(R.drawable.didyouknow4).into(four_pic);

        ImageView five_pic = findViewById(R.id.five_pic);
        Glide.with(this).load(R.drawable.didyouknow5).into(five_pic);

        ImageView six_pic = findViewById(R.id.six_pic);
        Glide.with(this).load(R.drawable.didyouknow6).into(six_pic);

        ImageView seven_pic = findViewById(R.id.seven_pic);
        Glide.with(this).load(R.drawable.didyouknow7).into(seven_pic);

        ImageView eight_pic = findViewById(R.id.eight_pic);
        Glide.with(this).load(R.drawable.didyouknow8).into(eight_pic);

        ImageView nine_pic = findViewById(R.id.nine_pic);
        Glide.with(this).load(R.drawable.didyouknow9).into(nine_pic);

        ImageView ten_pic = findViewById(R.id.ten_pic);
        Glide.with(this).load(R.drawable.didyouknow10).into(ten_pic);

        ImageView eleven_pic = findViewById(R.id.eleven_pic);
        Glide.with(this).load(R.drawable.didyouknow11).into(eleven_pic);

        AdView adView0 = findViewById(R.id.overviewAd0);
        AdView adView1 = findViewById(R.id.overviewAd1);
        AdView adView2 = findViewById(R.id.overviewAd2);
        AdView adView3 = findViewById(R.id.overviewAd3);
        AdView adView4 = findViewById(R.id.overviewAd4);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView0.loadAd(adRequest);
        adView1.loadAd(adRequest);
        adView2.loadAd(adRequest);
        adView3.loadAd(adRequest);
        adView4.loadAd(adRequest);
    }


    public void cardViewZero(View view) {
        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewZero.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewZero.class);
            startActivity(intent);
        }

    }

    public void cardViewOne(View view) {
        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewOne.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewOne.class);
            startActivity(intent);
        }
    }

    public void cardViewTwo(View view) {
        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewTwo.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewTwo.class);
            startActivity(intent);
        }
    }

    public void cardViewThree(View view) {

        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewThree.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewThree.class);
            startActivity(intent);
        }
    }

    public void cardViewFour(View view) {
        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewFour.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewFour.class);
            startActivity(intent);
        }
    }

    public void cardViewFive(View view) {
        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewFive.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewFive.class);
            startActivity(intent);
        }
    }

    public void cardViewSix(View view) {
        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewSix.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewSix.class);
            startActivity(intent);
        }
    }

    public void cardViewSeven(View view) {
        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewSeven.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewSeven.class);
            startActivity(intent);
        }
    }

    public void cardViewEight(View view) {
        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewEight.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewEight.class);
            startActivity(intent);
        }
    }

    public void cardViewNine(View view) {
        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewNine.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewNine.class);
            startActivity(intent);
        }
    }

    public void cardViewTen(View view) {
        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewTen.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewTen.class);
            startActivity(intent);
        }
    }

    public void cardViewEleven(View view) {
        interstitialAd.loadAd(new AdRequest.Builder().build());

        if (interstitialAd.isLoaded()) {
            interstitialAd.show();

            interstitialAd.setAdListener(new AdListener() {

                @Override
                public void onAdClosed() {
                    startActivity(new Intent(didYouKnow.this, cardViewEleven.class));
                    super.onAdClosed();
                }
            });

        } else {
            Intent intent = new Intent(this, cardViewEleven.class);
            startActivity(intent);
        }
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
}
