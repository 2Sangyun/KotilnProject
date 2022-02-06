package com.example.kotilnproject

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {
    @Insert
    fun insertAll(vararg history : History)

    @Query("SELECT * FROM test_history")
    fun getAll() : List<History>
}