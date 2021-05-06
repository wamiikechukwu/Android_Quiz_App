package com.wamiikechukwukanu.quizapp.repo;

import android.database.Cursor;

public interface DatabaseHelper {

    boolean insertFlagNameIntoDataBase(String firstLetter, String secondLetter, String thirdLetter, String fourthLetter, String fifthLetter, String sixthLetter, String seventhLetter, String eighthLetter, String ninthLetter, String tenthLetter, String eleventhLetter, String twelfthLetter);

    Cursor getFlagNameByIndex(int id);
}
