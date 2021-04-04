//package com.wamiikechukwukanu.quizapp.db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.wamiikechukwukanu.quizapp.model.BookMarks
//
//
//@Database(entities = arrayOf(BookMarks::class), version = 1)
//abstract class BookMarksDatabase : RoomDatabase() {
//
//    abstract fun bookMarksDao(): BookMarksDao
//
//    companion object {
//
//        private var instance: BookMarksDatabase? = null
//
//        fun getInstance(context: Context): BookMarksDatabase {
//            if (instance == null) {
//
//                instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        BookMarksDatabase::class.java,
//                        "BookMarks").build()
//            }
//
//            return instance as BookMarksDatabase
//        }
//    }
//}
