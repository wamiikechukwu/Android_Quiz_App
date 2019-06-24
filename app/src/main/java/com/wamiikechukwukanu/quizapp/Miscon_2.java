package com.wamiikechukwukanu.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Miscon_2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miscon_2);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, misconAfrica.class);
        startActivity(intent);
    }


    public void goNext(View view) {
    }
}
