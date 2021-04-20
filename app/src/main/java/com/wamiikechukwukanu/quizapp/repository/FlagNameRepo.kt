package com.wamiikechukwukanu.quizapp.repository

import com.wamiikechukwukanu.quizapp.dao.FlagNameDao
import com.wamiikechukwukanu.quizapp.model.FlagNameTable

class FlagNameRepo(private val flagNameDao: FlagNameDao) {
    suspend fun addFlagName(flagName: FlagNameTable) {
        flagNameDao.insertFlagName(flagName)
    }
}
