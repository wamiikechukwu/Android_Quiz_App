package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class misconAfrica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscon_africa);
    }

    public void misconceptionsOfAfrica(View view) {

        Intent intent = new Intent(this, Miscon_1.class);
        startActivity(intent);
    }

}
