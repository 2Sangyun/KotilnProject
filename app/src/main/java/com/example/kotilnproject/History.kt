package com.example.kotilnproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test_history")
data class History(
    @PrimaryKey(autoGenerate = true)
    var test_id : Int = 0,

    @ColumnInfo(name = "q1_ans")
    var q1_ans : String = "",

    @ColumnInfo(name = "q2_ans")
    var q2_ans : String = "",

    @ColumnInfo(name = "q3_ans")
    var q3_ans : String = "",

    @ColumnInfo(name = "score")
    var score : Int = 0,
)
