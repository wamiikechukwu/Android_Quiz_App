package com.wamiikechukwukanu.quizapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.wamiikechukwukanu.quizapp.model.FlagNameTable

@Dao
interface FlagNameDao {

//    @Query("SELECT * FROM Bookmarks WHERE id = :bookmarkID")
//    fun loadLiveBookmark(bookmarkID: Long): LiveData<BookMarks>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFlagName(insertingFlagsNames: FlagNameTable)

}
