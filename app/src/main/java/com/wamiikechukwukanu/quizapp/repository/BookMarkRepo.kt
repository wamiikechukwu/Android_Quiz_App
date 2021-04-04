//package com.wamiikechukwukanu.quizapp.repository
//
//import android.content.Context
//import androidx.lifecycle.LiveData
//import com.wamiikechukwukanu.quizapp.db.BookMarksDao
//import com.wamiikechukwukanu.quizapp.db.BookMarksDatabase
//import com.wamiikechukwukanu.quizapp.model.BookMarks
//
//class BookmarkRepo(context: Context) {
//
//    private var db = BookMarksDatabase.getInstance(context)
//    private var bookmarksDao: BookMarksDao = db.bookMarksDao()
//
//    fun addBookmark(booksmark: BookMarks): Long? {
//        val newId = bookmarksDao.insertBookmark(booksmark)
//        booksmark.id = newId
//        return newId
//    }
//
//    fun createBookmark(): BookMarks {
//        return BookMarks()
//    }
//
//    val allBookmarks: LiveData<ArrayList<BookMarks>>
//        get() {
//            return bookmarksDao.loadAll()
//        }
//}