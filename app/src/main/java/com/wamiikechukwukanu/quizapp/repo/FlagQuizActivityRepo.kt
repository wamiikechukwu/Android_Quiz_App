package com.wamiikechukwukanu.quizapp.repo

interface FlagQuizActivityRepo {

//    SAVE THE USER POINT TO THE SHARED PREF
    fun userPoint(point: Int)

//    GET THE VALUE FROM THE SHARED PREF
    fun getUserPoint():Int
}
