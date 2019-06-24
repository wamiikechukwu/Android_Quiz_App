package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Miscon_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscon_4);
    }


    public void goBack(View view) {
        Intent intent = new Intent(this, misconAfrica.class);
        startActivity(intent);
    }

    public void goNext(View view) {
    }
}
