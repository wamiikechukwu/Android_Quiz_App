package com.wamiikechukwukanu.quizapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wamiikechukwukanu.quizapp.dao.FlagNameDao
import com.wamiikechukwukanu.quizapp.model.FlagNameTable


@Database(entities = [FlagNameTable::class], version = 1, exportSchema = false)
abstract class FlagNameDataBase : RoomDatabase() {

    abstract fun flagNameDao(): FlagNameDao

    companion object {
        @Volatile
        private var INSTANCE: FlagNameDataBase? = null

        fun getDatabase(context: Context): FlagNameDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        FlagNameDataBase::class.java,
                        "flag_name_database")
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
