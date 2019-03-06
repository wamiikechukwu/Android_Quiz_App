package com.quizapp.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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


        //setQuestion();

    }
        public void nextQuestionButton(View view){

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
        ;
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



        boolean isAnswerCorrectOrNot = q.checkAnswer(answersOption());

        if (isAnswerCorrectOrNot) {
            q.increaseScoreByOne();
        }
        if (answersOption() == 4) {
            Toast.makeText(MainActivity.this, "Please select an option", Toast.LENGTH_LONG).show();
        }
        scoresTotalCorrectAnswer = q.getScore();

        clearSelection();
    }


}
