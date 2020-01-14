package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Miscon_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscon_1);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, misconAfrica.class);
        startActivity(intent);
    }

    public void goNext(View view) {
        Intent intent = new Intent(this, Miscon_2.class);
        startActivity(intent);
    }
}
