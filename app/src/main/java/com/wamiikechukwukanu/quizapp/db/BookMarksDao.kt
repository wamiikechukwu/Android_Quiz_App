//package com.wamiikechukwukanu.quizapp.db
//
//import androidx.lifecycle.LiveData
//import androidx.room.*
//import androidx.room.OnConflictStrategy.IGNORE
//import androidx.room.OnConflictStrategy.REPLACE
//import com.wamiikechukwukanu.quizapp.model.BookMarks
//
//@Dao
//interface BookMarksDao{
//    @Query("Select * from BookMarks")
//    fun loadAll():LiveData<ArrayList<BookMarks>>
//
//    @Query("SELECT * FROM BookMarks WHERE id = :bookMarkID")
//    fun bookMark(bookMarkID:Long):BookMarks
//
//    @Query("SELECT * FROM Bookmarks WHERE id = :bookmarkID")
//    fun loadLiveBookmark(bookmarkID: Long): LiveData<BookMarks>
//
//    @Insert(onConflict = IGNORE)
//    fun insertBookmark(bookmark: BookMarks): Long
//
//    @Update(onConflict = REPLACE)
//    fun updateBookmark(bookmark: BookMarks)
//
//    @Delete
//    fun deleteBookmark(bookmark: BookMarks)
//}