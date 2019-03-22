package com.quizapp.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView testQuestion;

    RadioButton answerA;
    RadioButton answerB;
    RadioButton answerC;
    RadioButton answerD;

    RadioGroup radioGroup_ID;

    ScrollView scrollViewLayout;
    RelativeLayout answerActivity;

    int scoresTotalCorrectAnswer = 0;

    int totalQuestionsAnswered = 1;

    int randomNumber = 0;

    Questions q = new Questions();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testQuestion = findViewById(R.id.testQuestion);

        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);

        radioGroup_ID = findViewById(R.id.radioGroup_ID);

        scrollViewLayout = findViewById(R.id.scrollViewLayout);
        answerActivity = findViewById(R.id.answerActivity);

        //setQuestion();

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
                Toast.makeText(this, "More clicked", Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu2:
                Toast.makeText(this, "Contact us clicked", Toast.LENGTH_LONG).show();
                return true;

            case R.id.menu3:
                changeBackGroundColour();
                return true;

            case R.id.menu4:
                Intent intent = new Intent(this, AnswerActivity.class);
                startActivity(intent);

                return true;

            case R.id.menu5:
                Toast.makeText(this, "Help clicked", Toast.LENGTH_LONG).show();
                return true;

            case R.id.submenu1:
                Toast.makeText(this, "sub item 1", Toast.LENGTH_LONG).show();

            case R.id.submenu2:
                Toast.makeText(this, "sub item 2", Toast.LENGTH_LONG).show();

            case R.id.submenu3:
                Toast.makeText(this, "sub item 2", Toast.LENGTH_LONG).show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void nextQuestionButton(View view) {

        if (totalQuestionsAnswered <= 4) {

            setQuestion();

            totalQuestionsAnswered++;

        } else {
            Intent nextLayout = new Intent(this, AnswerActivity.class);
            nextLayout.putExtra("nextLayout", "" + scoresTotalCorrectAnswer);
            startActivity(nextLayout);
        }
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
        randomNumber = randNum.nextInt(4);

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

    public void changeBackGroundColour() {
        scrollViewLayout.setBackgroundColor(Color.parseColor("#FFA41111"));
        answerActivity.setBackgroundColor(Color.parseColor("#FFA41111"));
    }

}
