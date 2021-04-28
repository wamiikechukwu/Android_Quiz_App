package com.wamiikechukwukanu.quizapp.repository

import com.wamiikechukwukanu.quizapp.dao.FlagNameDao
import com.wamiikechukwukanu.quizapp.model.FlagNameTable

class FlagNameRepo(private val flagNameDao: FlagNameDao) {
    suspend fun addFlagName(flagName: ArrayList<FlagNameTable>) {
        flagNameDao.insertFlagName(flagName)
    }

//      fun getFlagName(flagNameIndex:Long):ArrayList<FlagNameTable>{
//       return flagNameDao.getFlagNameIndex(flagNameIndex )
//    }
}
