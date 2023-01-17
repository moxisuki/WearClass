package com.moix.wearclass.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TimeDao {

    @Insert
    fun insert(time: TimeEntity)

    @Delete
    fun delete(time: TimeEntity)

    @Query("SELECT * FROM time_entity")
    fun getAllTimes(): LiveData<List<TimeEntity>>
    @Query("SELECT * FROM time_entity")
    fun getAllTimesList(): List<TimeEntity>

    @Query("SELECT * from time_entity")
    fun getAlphabetizedTimeList(): LiveData<List<TimeEntity>>
}