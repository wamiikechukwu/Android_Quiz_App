package com.quizapp.quizapp;

public class Questions {

    int position;
    int score = 0;

    String[] questionsToBeAsked = {

            "1. Which part of Africa can Ghana be located",
            "2. What is the capital of Nigeria",
            "3. Which of these countries are not located in Africa",
            "4. What is the estimated population of Africa, as at 2015"

    };

    String[][] answersToTheQuestions = {

            {
                    " A: West Africa",
                    " B: East Africa",
                    " C: Central Africa",
                    " D: North Africa"
            },

            {
                    " A: Abuja",
                    " B: Kano",
                    " C: Lagos",
                    " D: Port Harcourt"
            },

            {
                    " A: Niger",
                    " B: Nigeria",
                    " C: Rwanda",
                    " D: Non of the above"
            },

            {
                    " A: 1.2 Billion",
                    " B: 500 Billion",
                    " C: 2 Billion",
                    " D: 360 million"
            },
    };

    int[] questionsCorrectAnswers = {0, 0, 3, 0};

    public void setQuestionNumber(int position) {
        this.position = position;
    }

    public String getQuestionsFromTheArray() {
        return questionsToBeAsked[position];
    }

    public String getOptionOneFromTheArray() {
        return answersToTheQuestions[position][0];
    }

    public String getOptionTwoFromTheArray() {
        return answersToTheQuestions[position][1];
    }

    public String getOptionThreeFromTheArray() {
        return answersToTheQuestions[position][2];
    }

    public String getOptionFourFromTheArray() {
        return answersToTheQuestions[position][3];
    }

    String quest;

    public void increaseScoreByOne() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public boolean checkAnswer(int option) {
        return option == questionsCorrectAnswers[position];
    }
}
