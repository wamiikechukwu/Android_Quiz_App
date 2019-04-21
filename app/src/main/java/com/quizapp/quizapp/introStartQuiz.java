package com.quizapp.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class introStartQuiz extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //global variable for the total number of questions
    public int questionNumb = 0;
    //global variable for questionSpinner view ID
    Spinner questionSpinner;
    //global variable for difficultSpinner view ID
    Spinner difficultSpinner;
    //global variable for the questionSpinner item
    private String myQuestionLabel = "";
    //global variable for the questionSpinner item
    private String myDifficultLabel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_start_quiz);

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

        if (myQuestionLabel.equals("0")) {
            Toast.makeText(this, "No Questions Selected", Toast.LENGTH_LONG).show();
            questionNumb = 0;
        }

        if (myQuestionLabel.equals("1")) {
            Toast.makeText(this, "1 Question Selected", Toast.LENGTH_LONG).show();
            questionNumb = 1;
        }

        if (myQuestionLabel.equals("2")) {
            Toast.makeText(this, "2 Questions Selected", Toast.LENGTH_LONG).show();
            questionNumb = 2;
        }

        if (myQuestionLabel.equals("3")) {
            Toast.makeText(this, "3 Questions Selected", Toast.LENGTH_LONG).show();
            questionNumb = 3;
        }

        if (myQuestionLabel.equals("4")) {
            Toast.makeText(this, "4 Questions Selected", Toast.LENGTH_LONG).show();
            questionNumb = 4;
        }

        if (myQuestionLabel.equals("5")) {
            Toast.makeText(this, "5 Questions Selected", Toast.LENGTH_LONG).show();
            questionNumb = 5;
        }

        if (myQuestionLabel.equals("6")) {
            Toast.makeText(this, "6 Questions Selected", Toast.LENGTH_LONG).show();
            questionNumb = 6;
        }

        //logic for how difficult the questions should be

        if (myDifficultLabel.equals("Easy")) {
            Toast.makeText(this, "Easy Level Selected", Toast.LENGTH_LONG).show();
            questionNumb = 1;
        }

        if (myQuestionLabel.equals("Normal")) {
            Toast.makeText(this, "Normal Level Selected", Toast.LENGTH_LONG).show();
            questionNumb = 2;
        }

        if (myQuestionLabel.equals("Hard")) {
            Toast.makeText(this, "Hard Level Selected", Toast.LENGTH_LONG).show();
            questionNumb = 0;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d("intro", getString(R.string.nothing_selected));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}
