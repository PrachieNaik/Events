package com.example.events

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Event::class), version = 2)
abstract class EventDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDAO
    companion object{
        @Volatile var instance: EventDatabase ? = null
        private val Lock=Any()
        operator fun invoke(context: Context)= instance ?: synchronized(Lock)
        {
            instance ?: buildDatabase(context).also{
                instance = it
            }
           // Log.e("EDB","invoked")
        }
        private fun buildDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            EventDatabase::class.java,
            "eventdatabase"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    }

}