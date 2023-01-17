package com.moix.wearclass.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.moix.wearclass.WearApplication
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: AppRepository
    private val allLessonEntity: LiveData<List<LessonEntity>>

    private val repository2: TimeRepository
    private val allTimeEntity: LiveData<List<TimeEntity>>

    init {
        val database = AppDatabase.getDatabase(application, viewModelScope)
        repository = AppRepository(database.lessonDao())
        allLessonEntity = repository.allLessons
        repository2 = TimeRepository(database.timeDao())
        allTimeEntity = repository2.allTimes
    }

    fun test() = viewModelScope.launch {
        val timeEntity = TimeEntity(0,1,2,1,1)
        repository2.insert(timeEntity)
        repository2.getCurrentTimeEntity()
    }


    fun insert(lessonEntity: LessonEntity) = viewModelScope.launch {
        repository.insert(lessonEntity)
        Log.d(WearApplication.TAG, "insert: $lessonEntity")
    }

    fun getAllLessons(): LiveData<List<LessonEntity>> {
        return allLessonEntity
    }
}