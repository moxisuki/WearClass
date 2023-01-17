package com.moix.wearclass.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LessonDao {
        @Insert
        fun insert(lesson: LessonEntity)

        @Insert
        fun insertAll(vararg lessons: LessonEntity)

        @Delete
        fun delete(lesson: LessonEntity)
        @Query("SELECT * FROM lesson_entity")
        fun getAllLessons(): LiveData<List<LessonEntity>>

        @Query("SELECT * from lesson_entity")
        fun getAlphabetizedLessonList(): LiveData<List<LessonEntity>>
}