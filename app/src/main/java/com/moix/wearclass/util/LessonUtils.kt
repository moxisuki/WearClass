package com.moix.wearclass.util

import android.util.Log
import com.moix.wearclass.WearApplication
import com.moix.wearclass.data.LessonEntity
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

object LessonUtils {

    fun isInLesson(lessonEntity: LessonEntity): Boolean {
        val date = LocalDate.now()
        Log.d(WearApplication.TAG, "isInLesson: ${date.dayOfWeek.value}")
        return if(date.dayOfWeek.value == lessonEntity.dayOfWeek){
            val time = LocalTime.now()
            val hour = time.hour
            val minute = time.minute

            true
        }else{
            false
        }
    }

}