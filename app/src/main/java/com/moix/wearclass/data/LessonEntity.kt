package com.moix.wearclass.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lesson_entity")
data class LessonEntity(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "day_of_week") val dayOfWeek: Int?,
    @ColumnInfo(name = "start_time") val startTime: Int?,
    @ColumnInfo(name = "over_time") val overTime: Int?,
    @ColumnInfo(name = "show_name") val showName: String?,
    @ColumnInfo(name = "classroom") val classroom: String?,
    @ColumnInfo(name = "teacher") val teacher: String?,
    @ColumnInfo(name = "location") val location: String?
)
