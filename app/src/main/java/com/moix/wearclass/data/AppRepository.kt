package com.moix.wearclass.data

import androidx.lifecycle.LiveData

class AppRepository(private val lessonDao: LessonDao) {
    val allLessons: LiveData<List<LessonEntity>> = lessonDao.getAlphabetizedLessonList()

    suspend fun insert(lessonEntity: LessonEntity){
        lessonDao.insert(lessonEntity)
    }

    suspend fun getAllLessons(): LiveData<List<LessonEntity>> {
        return lessonDao.getAllLessons()
    }
}