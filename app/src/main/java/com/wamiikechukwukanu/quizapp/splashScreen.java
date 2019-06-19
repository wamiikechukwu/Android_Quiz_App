package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class splashScreen extends AppCompatActivity {

    //Seconds after which the splash screens disappears
    int secondsToDelay = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         The codes belows are written to hide the app's title, action bar and to enable a full screen mode
         */
        try {

            //Hides the application title (Eg: Africa Quiz App)
            requestWindowFeature(Window.FEATURE_NO_TITLE);

            //Hides the Action bar
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();

            //Enables the Full Screen
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } catch (Exception e) {
            Toast.makeText(this, "Error Detected", Toast.LENGTH_SHORT).show();
        }
        setContentView(R.layout.activity_splash_screen);

        ImageView imageView = findViewById(R.id.splash_screen);

        Glide.with(this).load(R.drawable.africa_map).into(imageView);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splashScreen.this, overView.class));
                finish();

            }

        }, secondsToDelay * 1000);
    }
}
