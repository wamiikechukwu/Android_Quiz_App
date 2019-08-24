package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class score extends AppCompatActivity {

    TextView textview;

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_score);

        textview = findViewById(R.id.textview);

        ImageView imageView = findViewById(R.id.image);

        data = getIntent().getStringExtra("nextLayout");

        textview.setText(data);

        Glide.with(this)
                .load(R.drawable.trophy)
                .into(imageView);

        //Referencing the aadId from admob and initialing it
        MobileAds.initialize(this, "ca-app-pub-9646388292265496/4392647445");

        AdView adView0 = findViewById(R.id.overviewAd0);
        AdView adView1 = findViewById(R.id.overviewAd1);

        AdRequest adRequest = new AdRequest.Builder().build();

        adView0.loadAd(adRequest);
        adView1.loadAd(adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void tryAgain(View view) {

        Intent intent = new Intent(this, overView.class);
        startActivity(intent);
    }

    public void whatsapp(View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        try {

            getPackageManager().getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            intent.setPackage("com.whatsapp");
            intent.putExtra(Intent.EXTRA_TEXT, "Hey, i scored " + data + " in Africa Quiz App, download it via this link XXX");
            startActivity(Intent.createChooser(intent, "Share with"));

        } catch (PackageManager.NameNotFoundException e) {

            Toast toast = Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT);
            toast.show();

        }

    }

}



