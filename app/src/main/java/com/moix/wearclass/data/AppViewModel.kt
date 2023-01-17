package com.moix.wearclass.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.moix.wearclass.WearApplication
import kotlinx.coroutines.launch

class AppViewModel(application: Application): AndroidViewModel(application) {

    private val repository:AppRepository
    val allLessonEntity:LiveData<List<LessonEntity>>
    init {
        val wordsDao = AppDatabase.getDatabase(application,viewModelScope).lessonDao()
        repository = AppRepository(wordsDao)
        allLessonEntity = repository.allLessons
    }

    fun insert(lessonEntity: LessonEntity) = viewModelScope.launch {
        repository.insert(lessonEntity)
        Log.d(WearApplication.TAG, "insert: $lessonEntity")
    }

    fun getAllLessons(): LiveData<List<LessonEntity>> {
        return allLessonEntity
    }
}