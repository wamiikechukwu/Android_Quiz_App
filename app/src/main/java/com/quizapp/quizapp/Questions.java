package com.quizapp.quizapp;

public class Questions {

    private int position;
    private int score = 0;

    String[] questionsToBeAsked = {

            "Which part of Africa can Ghana be located",
            "What is the capital of Nigeria",
            "Which of these countries are not located in Africa",
            "What is the estimated population of Africa, as at 2015",
            "What percentage of all the land on the planet Earth does Africa cover?",
            "What are the origins of the name 'Africa'? The name has its origins in a small country " +
                    "in the North of Africa (Tunisia) and it means:",

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

            {
                    "A: 20%",
                    "B: 50%",
                    "C: 70%",
                    "D: 15%"
            },

            {
                    "A: Black Island",
                    "B: Sunny Place",
                    "C: Land of Black People",
                    "D: Dry Place"
            },
    };

    int[] questionsCorrectAnswers = {0, 0, 3, 0, 0, 1,};

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
