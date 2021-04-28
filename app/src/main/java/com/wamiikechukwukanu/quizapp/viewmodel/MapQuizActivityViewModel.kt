package com.wamiikechukwukanu.quizapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.wamiikechukwukanu.quizapp.db.FlagNameDataBase
import com.wamiikechukwukanu.quizapp.model.FlagNameTable
import com.wamiikechukwukanu.quizapp.repository.FlagNameRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MapQuizActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: FlagNameRepo

    init {
        val flagDao = FlagNameDataBase.getDatabase(application).flagNameDao()
        repository = FlagNameRepo(flagDao)
    }

    fun addFlagName(flagName: ArrayList<FlagNameTable>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFlagName(flagName)
        }
    }

//    fun getFlagIndex(flagPosition:Long){
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.getFlagName(flagPosition)
//        }
//
//    }
}
