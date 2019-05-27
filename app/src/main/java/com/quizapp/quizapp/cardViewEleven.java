package com.quizapp.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class cardViewEleven extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_eleven);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, didYouKnow.class);
        startActivity(intent);
    }
}
