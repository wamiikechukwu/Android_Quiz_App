package com.wamiikechukwukanu.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class introStartQuiz extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //global variable for questionSpinner view ID
    Spinner questionSpinner;
    //global variable for difficultSpinner view ID
    Spinner difficultSpinner;
    //global variable for the questionSpinner item
    private String myQuestionLabel = "";
    //global variable for the questionSpinner item
    private String myDifficultLabel = "";

    public AdView overviewAd;
    public AdView overviewAd1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_start_quiz);

        overviewAd = findViewById(R.id.overviewAd);
        overviewAd1 = findViewById(R.id.overviewAd1);

        //Referencing the aadId from admob and initialing it
        MobileAds.initialize(this, "ca-app-pub-9646388292265496~7436300103");

        AdRequest adRequest = new AdRequest.Builder().build();
        overviewAd.loadAd(adRequest);
        overviewAd1.loadAd(adRequest);

        //getting the questionSpinner ID
        questionSpinner = findViewById(R.id.question_Array);

        //getting the difficultSpinner ID
        difficultSpinner = findViewById(R.id.difficult_Array);

        if (questionSpinner != null) {
            questionSpinner.setOnItemSelectedListener(this);
        }

        if (difficultSpinner != null) {
            difficultSpinner.setOnItemSelectedListener(this);
        }

        // Create ArrayAdapter using the string array and default questionSpinner layout.
        ArrayAdapter<CharSequence> questionAdapter = ArrayAdapter.createFromResource(this,
                R.array.question_Array, android.R.layout.simple_spinner_item);

        // Create ArrayAdapter using the string array and default difficultSpinner layout.
        ArrayAdapter<CharSequence> difficultAdapter = ArrayAdapter.createFromResource(this,
                R.array.difficult_Array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        questionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Specify the layout to use when the list of choices appears.
        difficultAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // Apply the questionAdapter to the questionSpinner.
        if (questionSpinner != null) {
            questionSpinner.setAdapter(questionAdapter);
        }

        // Apply the questionAdapter to the questionSpinner.
        if (difficultSpinner != null) {
            difficultSpinner.setAdapter(difficultAdapter);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        myQuestionLabel = adapterView.getItemAtPosition(i).toString();
        myDifficultLabel = adapterView.getItemAtPosition(i).toString();

        //storing the values in sharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("QuestNumb", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        if (myQuestionLabel.equals("1")) {
            editor.putInt("Numb", 1);
            editor.apply();
            Snackbar.make(view, "1 Question Selected", Snackbar.LENGTH_LONG).setAction
                    ("",
                            null).show();
        }

        if (myQuestionLabel.equals("5")) {
            editor.putInt("Numb", 5);
            editor.apply();
            Snackbar.make(view, "5 Questions Selected", Snackbar.LENGTH_LONG).setAction
                    ("",
                            null).show();
        }

        if (myQuestionLabel.equals("15")) {
            editor.putInt("Numb", 15);
            editor.apply();
            Snackbar.make(view, "15 Questions Selected", Snackbar.LENGTH_LONG).setAction
                    ("",
                            null).show();
        }

        if (myQuestionLabel.equals("20")) {
            editor.putInt("Numb", 20);
            editor.apply();
            Snackbar.make(view, "20 Questions Selected", Snackbar.LENGTH_LONG).setAction
                    ("",
                            null).show();
        }

        if (myQuestionLabel.equals("25")) {
            editor.putInt("Numb", 25);
            editor.apply();
            Snackbar.make(view, "25 Questions Selected", Snackbar.LENGTH_LONG).setAction
                    ("",
                            null).show();
        }

        if (myQuestionLabel.equals("30")) {
            editor.putInt("Numb", 30);
            editor.apply();
            Snackbar.make(view, "30 Questions Selected", Snackbar.LENGTH_LONG).setAction
                    ("",
                            null).show();
        }

        if (myQuestionLabel.equals("35")) {
            editor.putInt("Numb", 35);
            editor.apply();
            Snackbar.make(view, "35 Questions Selected", Snackbar.LENGTH_LONG).setAction
                    ("",
                            null).show();
        }

        //logic for how difficult the questions should be

        if (myDifficultLabel.equals("Easy")) {
            Toast.makeText(this, "Easy Level Selected", Toast.LENGTH_LONG).show();
        }

        if (myQuestionLabel.equals("Normal")) {
            Toast.makeText(this, "Normal Level Selected", Toast.LENGTH_LONG).show();
        }

        if (myQuestionLabel.equals("Hard")) {
            Toast.makeText(this, "Hard Level Selected", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

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

    public void quizQuestions(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
