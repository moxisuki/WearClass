package com.moix.wearclass.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.moix.wearclass.WearApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [LessonEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun lessonDao(): LessonDao

    private class AppDatabaseCallback(
        private val scope: CoroutineScope
    ) : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            // TODO just test
            INSTANCE?.let { database ->
                scope.launch {
                    Log.d(WearApplication.TAG, "onCreate: Database Init")
                }

            }
        }
    }

        companion object {
            @Volatile
            private var INSTANCE: AppDatabase? = null

            fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    ).allowMainThreadQueries().addCallback(AppDatabaseCallback(scope)).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }