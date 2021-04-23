package com.wamiikechukwukanu.quizapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.wamiikechukwukanu.quizapp.model.FlagNameTable

@Dao
interface FlagNameDao {

//    @Query("SELECT * FROM flag_name_table WHERE id = :flagNameIndex")
//    fun getFlagNameIndex(flagNameIndex: Int): ArrayList<FlagNameTable>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFlagName(insertingFlagsNames: ArrayList<FlagNameTable>)

}
