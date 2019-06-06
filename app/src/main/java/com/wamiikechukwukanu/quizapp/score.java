package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class score extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        textview = findViewById(R.id.textview);

        ImageView imageView = findViewById(R.id.image);

        String data = getIntent().getStringExtra("nextLayout");

        textview.setText(data);

        Glide.with(this)
                .load(R.drawable.trophy)
                .into(imageView);

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
}
