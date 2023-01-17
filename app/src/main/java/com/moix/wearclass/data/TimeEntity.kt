package com.moix.wearclass.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "time_entity")
data class TimeEntity(
    @PrimaryKey(autoGenerate = true)
    val uid:Int,
    @ColumnInfo(name = "begin_time")
    val begin:Int,
    @ColumnInfo(name = "end_time")
    val end:Int,
    @ColumnInfo(name = "day_of_week")
    val dayOfWeek:Int,
    @ColumnInfo(name = "part_of_day")
    val partOfDay:Int,
)
