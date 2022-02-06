package com.example.kotilnproject.DataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {
    @Insert
    fun insertAll(vararg history : History)

    @Query("SELECT * FROM test_history")
    fun getAll() : List<History>

    @Query("DELETE FROM test_history")
    fun deleteAll()
}