package com.wamiikechukwukanu.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public AdView overviewAd1;
    public AdView overviewAd0;
    //initialized  global variable
    TextView testQuestion;
    TextView questionText;
    ProgressBar pBar;
    RadioButton answerA;
    RadioButton answerB;
    RadioButton answerC;
    RadioButton answerD;
    RadioGroup radioGroup_ID;
    ScrollView scrollViewLayout;

    //variables for storing data
    int scoresTotalCorrectAnswer = 0;
    int totalQuestionsAnswered = 1;
    int randomNumber = 0;
    //the sharedpreference that stores the total number of questions the user wants to answer
    int name;
    //Calling the constructor from the question class
    Questions q = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the view reference
        testQuestion = findViewById(R.id.testQuestion);
        questionText = findViewById(R.id.questionText);

        pBar = findViewById(R.id.progressBar);

        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);

        radioGroup_ID = findViewById(R.id.radioGroup_ID);

        scrollViewLayout = findViewById(R.id.scrollViewLayout);

        overviewAd1 = findViewById(R.id.overviewAd1);
        overviewAd0 = findViewById(R.id.overviewAd0);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111");

        AdRequest adRequest = new AdRequest.Builder().build();
        overviewAd0.loadAd(adRequest);
        overviewAd1.loadAd(adRequest);

        setQuestion();
    }

    //This @Override method here inflate/add the menu to the activity
    //and this must be added unto every activity you want the menu to appear on
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    //This @Override method tells the menu what to do  or displays when a user clicks on it
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

    public void nextQuestionButton(View view) {

        //storing data via shared preference
        SharedPreferences sharedPref = getSharedPreferences("QuestNumb", Context.MODE_PRIVATE);
        name = sharedPref.getInt("Numb", 0);

        // set the maximum value the progress bar can contain
        pBar.setMax(name);

        if (totalQuestionsAnswered < name) {

            setQuestion();

            //incrementing the progress bar by 1
            pBar.incrementProgressBy(1);

            //incrementing the total number of questions answered by 1
            totalQuestionsAnswered++;

        } else {
            Intent nextLayout = new Intent(this, score.class);
            nextLayout.putExtra("nextLayout", "" + scoresTotalCorrectAnswer);
            startActivity(nextLayout);
        }


        //set the question number as the user answers them
        questionText.setText("Question " + totalQuestionsAnswered);

        //i couldn't concatenate all the string together so i had to split it using .append
        questionText.append(" / " + name);
    }

    public void clearSelection() {
        radioGroup_ID.clearCheck();
    }

    public int answersOption() {

        if (answerA.isChecked()) {
            return 0;
        }

        if (answerB.isChecked()) {
            return 1;
        }

        if (answerC.isChecked()) {
            return 2;
        }

        if (answerD.isChecked()) {
            return 3;
        }
        return 4;
    }

    public void setQuestion() {
        Random randNum = new Random();

        //the random number will generate random numbers in coordinate to the available questions
        randomNumber = randNum.nextInt(35);

        q.setQuestionNumber(randomNumber);

        testQuestion.setText(q.getQuestionsFromTheArray());

        answerA.setText(q.getOptionOneFromTheArray());
        answerB.setText(q.getOptionTwoFromTheArray());
        answerC.setText(q.getOptionThreeFromTheArray());
        answerD.setText(q.getOptionFourFromTheArray());

        radioGroup_ID.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int option = answersOption();
                if (option == 4) {
                    Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_LONG).show();
                } else {
                    boolean isAnswerCorrectOrNot = q.checkAnswer(option);
                    if (isAnswerCorrectOrNot) {
                        q.increaseScoreByOne();
                        scoresTotalCorrectAnswer = q.getScore();
                    }
                }
            }

        });

        clearSelection();
    }

}
