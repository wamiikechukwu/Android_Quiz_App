package com.quizapp.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class didYouKnow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_did_you_know);
    }


    public void cardViewZero(View view) {
        Intent intent = new Intent(this, cardViewZero.class);
        startActivity(intent);
    }

    public void cardViewOne(View view) {
        Intent intent = new Intent(this, cardViewOne.class);
        startActivity(intent);

    }

    public void cardViewTwo(View view) {
        Intent intent = new Intent(this, cardViewTwo.class);
        startActivity(intent);
    }

    public void cardViewThree(View view) {
        Intent intent = new Intent(this, cardViewThree.class);
        startActivity(intent);
    }

    public void cardViewFour(View view) {
        Intent intent = new Intent(this, cardViewFour.class);
        startActivity(intent);
    }

    public void cardViewFive(View view) {
        Intent intent = new Intent(this, cardViewFive.class);
        startActivity(intent);
    }

    public void cardViewSix(View view) {
    }
}
