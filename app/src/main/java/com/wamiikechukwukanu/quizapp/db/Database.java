package com.wamiikechukwukanu.quizapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.facebook.internal.LockOnGetVariable;
import com.wamiikechukwukanu.quizapp.repo.DatabaseHelper;

public class Database extends SQLiteOpenHelper {
    private static final String databaseName = "AfricaQuizApp.db";
    private static final String tableName = "flagNames";

    public Database(@Nullable Context context) {
        super(context, databaseName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + tableName +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstLetter TEXT, " +
                "secondLetter TEXT, " +
                "thirdLetter TEXT, " +
                "fourthLetter TEXT, " +
                "fifthLetter TEXT, " +
                "sixthLetter TEXT, " +
                "seventhLetter TEXT, " +
                "eighthLetter TEXT, " +
                "ninthLetter TEXT, " +
                "tenthLetter TEXT," +
                "eleventhLetter TEXT, " +
                "twelfthLetter TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + tableName);
        onCreate(sqLiteDatabase);
    }


    public boolean insertFlagNameIntoDataBase(int id, String firstLetter, String secondLetter, String thirdLetter, String fourthLetter, String fifthLetter, String sixthLetter, String seventhLetter, String eighthLetter, String ninthLetter, String tenthLetter, String eleventhLetter, String twelfthLetter) {
        SQLiteDatabase sqliteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("firstLetter", firstLetter);
        contentValues.put("secondLetter", secondLetter);
        contentValues.put("thirdLetter", thirdLetter);
        contentValues.put("fourthLetter", fourthLetter);
        contentValues.put("fifthLetter", fifthLetter);
        contentValues.put("sixthLetter", sixthLetter);
        contentValues.put("seventhLetter", seventhLetter);
        contentValues.put("eighthLetter", eighthLetter);
        contentValues.put("ninthLetter", ninthLetter);
        contentValues.put("tenthLetter", tenthLetter);
        contentValues.put("eleventhLetter", eleventhLetter);
        contentValues.put("twelfthLetter", twelfthLetter);

        long result = sqliteDatabase.insert(tableName, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getFlagNameByIndex(String id) {
        id = "'" + id + "'";
        SQLiteDatabase sqLiteOpenHelper = this.getWritableDatabase();
        return sqLiteOpenHelper.rawQuery("select * from" + tableName + " where _id " + id, null);

    }


}
