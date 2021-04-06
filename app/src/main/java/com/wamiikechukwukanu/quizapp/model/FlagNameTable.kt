package com.wamiikechukwukanu.quizapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flag_name_table")
data class FlagNameTable(
        @PrimaryKey(autoGenerate = true)
        var id: Long,
        var firstLetter: String,
        var secondLetter: String,
        var thirdLetter: String,
        var fourthLetter: String,
        var fifthLetter: String,
        var sixthLetter: String,
        var seventhLetter: String,
        var eighthLetter: String,
        var ninthLetter: String,
        var tenthLetter: String,
        var eleventhLetter: String,
        var twelfthLetter: String)