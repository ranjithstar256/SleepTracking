package com.example.jetpackroomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep_trackerr")
data class SleepData(

    @PrimaryKey(autoGenerate = true)
    var itemId: Long = 0L,

    @ColumnInfo(name = "datetime")
    val datetim: String,

    @ColumnInfo(name = "slept_for")
    var sleptfor: String
)