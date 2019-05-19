package com.quizapp.quizapp;

public class Questions {

    private int position;
    private int score = 0;

    String[] questionsToBeAsked = {

            "Which region in Africa can Ghana be located",
            "What is the capital of Nigeria",
            "Which of these countries are not located in Africa",
            "What is the estimated population of Africa, as at 2015",
            "What percentage of all the land on the planet Earth does Africa cover?",
            "What are the origins of the name 'Africa'? The name has its origins in a small country " +
                    "in the North of Africa (Tunisia) and it means:",
            "In 1950, how many people lived in Africa",
            "What is the distance from the top of Africa (i.e. its most northerly point) to the bottom" +
                    " of Africa (its most southerly point)?",
            "Along with lions, elephants and giraffes, is Africa also home to penguins?",
            "How many different languages are spoken across Africa?",          //10 Questions
            "Which country is Africa'a most popular tourist destination?",
            "To make chocolate you need cocoa beans. Approximately how much of the world's cocoa bean " +
                    "crop is grown in West Africa?",
            "What is the name of the fast food dish popular in South Africa, which is made by " +
                    "filling a hollowed-out loaf of bread with curry?",
            "Which sea is Africa bounded to in the North",
            "Africa is bounded by which sea in the NorthEast"

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

            {
                    "A: 1.2 Billion People",
                    "B: 200 Million People",
                    "C: 400 Million People",
                    "D: 221 Million People",
            },

            {
                    "A: 1500 Miles",
                    "B: 5000 Miles",
                    "C: 3000 Miles",
                    "D: 7000 Miles",
            },

            {
                    "A: Yes",
                    "B: No",
                    "C: Maybe",
                    "D: I have no idea",
            },

            {
                    "A: 100",
                    "B: 3",
                    "C: 3000",
                    "D: 10",
            },

            {
                    "A: Nigeria",
                    "B: South Africa",
                    "C: Egypt",
                    "D: Rwanda",
            },

            {
                    "A: 50%",
                    "B: 10%",
                    "C: 66%",
                    "D: 1%",
            },

            {
                    "A: Bunny Chow",
                    "B: Ewedu",
                    "C: Shigala",
                    "D: Okadu",
            },

            {
                    "A: Mediterranean Sea",
                    "B: Red Sea",
                    "C: Caspian Sea",
                    "D: Black Sea",
            },

            {
                    "A: Caribbean Sea",
                    "B: The Sea of Crete",
                    "C: Red Sea",
                    "D: The Sea of Galilee",
            },
    };

    int[] questionsCorrectAnswers = {0, 0, 3, 0, 0, 1, 3, 1, 0, 2, 2, 2, 0, 0, 2,};

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
