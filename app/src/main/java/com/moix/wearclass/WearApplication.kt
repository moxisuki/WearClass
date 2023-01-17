package com.moix.wearclass

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.moix.wearclass.data.AppDatabase
import com.moix.wearclass.data.LessonEntity

// Application
class WearApplication : Application() {
    companion object {
        private lateinit var instance: WearApplication
        public val TAG: String = "WearClassLog"

        public fun getInstance(): WearApplication {
            return instance;
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}