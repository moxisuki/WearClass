package com.moix.wearclass.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.moix.wearclass.WearApplication

class TimeRepository(private val timeDao: TimeDao) {
    val allTimes: LiveData<List<TimeEntity>> = timeDao.getAlphabetizedTimeList()

    suspend fun insert(timeEntity: TimeEntity) {
        timeDao.insert(timeEntity)
        Log.d(WearApplication.TAG, "insert: $timeEntity")
    }

    suspend fun getAllTimes(): LiveData<List<TimeEntity>> {
        return timeDao.getAllTimes()
    }

    suspend fun getAllTimesList(): List<TimeEntity> {
        return timeDao.getAllTimesList()
    }

    suspend fun getCurrentTimeEntity() {
        Log.d(WearApplication.TAG, "getCurrentTimeEntity Ook")
        getAllTimesList().forEach {
            Log.d(WearApplication.TAG, "getCurrentTimeEntity: $it")
        }
    }
}