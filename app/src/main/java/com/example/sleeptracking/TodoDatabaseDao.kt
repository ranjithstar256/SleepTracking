package com.example.jetpackroomdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDatabaseDao {
    @Query("SELECT * from sleep_trackerr")
    fun getAll(): LiveData<List<SleepData>>

    @Query("SELECT * from sleep_trackerr where itemId = :id")
    fun getById(id: Int) : SleepData?

    @Insert
    suspend fun insert(item:SleepData)

    @Update
    suspend fun update(item:SleepData)

    @Delete
    suspend fun delete(item:SleepData)

    @Query("DELETE FROM sleep_trackerr")
    suspend fun deleteAllTodos()
}